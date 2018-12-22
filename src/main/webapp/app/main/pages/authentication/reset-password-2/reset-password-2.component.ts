import { Component, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/internal/operators';
import * as _ from 'lodash';

import { FuseConfigService } from 'app/@fuse/services/config.service';
import { fuseAnimations } from 'app/@fuse/animations';
import { ActivatedRoute } from '@angular/router';
import { PasswordResetFinishService } from 'app/account';

@Component({
    selector: 'reset-password-2',
    templateUrl: './reset-password-2.component.html',
    styleUrls: ['./reset-password-2.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class ResetPassword2Component implements OnInit, OnDestroy {

    resetPasswordForm: FormGroup;
    key: string;
    success = false;

    // Private
    private _unsubscribeAll: Subject<any>;

    constructor(
        private passwordResetFinishService: PasswordResetFinishService,
        private route: ActivatedRoute,
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder
    ) {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar: {
                    hidden: true
                },
                toolbar: {
                    hidden: true
                },
                footer: {
                    hidden: true
                },
                sidepanel: {
                    hidden: true
                }
            }
        };

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        this.resetPasswordForm = this._formBuilder.group({
            email: ['', [Validators.required, Validators.email]],
            password: ['', Validators.required],
            passwordConfirm: ['', [Validators.required, confirmPasswordValidator]]
        });

        this.route.queryParams.subscribe(params => {
            this.key = _.trim(params['key']);
            if(this.key === '') {
                setTimeout(() => {
                    this.resetPasswordForm.setErrors({ keyMissing: true });
                });
            }
        });

        // Update the validity of the 'passwordConfirm' field
        // when the 'password' field changes
        this.resetPasswordForm.get('password').valueChanges
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.resetPasswordForm.get('passwordConfirm').updateValueAndValidity();
            });
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    finishReset() {
        // this.doNotMatch = null;
        // this.error = null;
        // if (this.resetAccount.password !== this.confirmPassword) {
            // this.doNotMatch = 'ERROR';
        // } else {
            this.passwordResetFinishService.save({ key: this.key, newPassword: this.resetPasswordForm.get('password').value }).subscribe(
                () => {
                    setTimeout(() => {
                        this.resetPasswordForm.reset({});
                        this.resetPasswordForm.setErrors(null);
                        this.resetPasswordForm.controls.email.setErrors(null);
                        this.resetPasswordForm.controls.password.setErrors(null);
                        this.resetPasswordForm.controls.passwordConfirm.setErrors(null);
                    });
                    this.success = true;
                },
                () => {
                    // this.success = null;
                    // this.error = 'ERROR';
                    this.resetPasswordForm.setErrors({ error: true });
                }
            );
        // }
    }

}

/**
 * Confirm password validator
 *
 * @param {AbstractControl} control
 * @returns {ValidationErrors | null}
 */
export const confirmPasswordValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {

    if (!control.parent || !control) {
        return null;
    }

    const password = control.parent.get('password');
    const passwordConfirm = control.parent.get('passwordConfirm');

    if (!password || !passwordConfirm) {
        return null;
    }

    if (passwordConfirm.value === '') {
        return null;
    }

    if (password.value === passwordConfirm.value) {
        return null;
    }

    return { 'passwordsNotMatching': true };
};
