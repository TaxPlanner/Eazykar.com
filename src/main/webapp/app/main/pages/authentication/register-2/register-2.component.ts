import { AfterViewInit, Component, OnDestroy, OnInit, Renderer2, ViewEncapsulation } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { FuseConfigService } from '../../../../@fuse/services/config.service';
import { fuseAnimations } from '../../../../@fuse/animations';
import { HttpErrorResponse } from '@angular/common/http';
import { EMAIL_ALREADY_USED_TYPE, LOGIN_ALREADY_USED_TYPE } from 'app/shared';
import { Register } from 'app/account';

@Component({
    selector: 'register-2',
    templateUrl: './register-2.component.html',
    styleUrls: ['./register-2.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class Register2Component implements OnInit, AfterViewInit, OnDestroy {
    registerForm: FormGroup;

    // Private
    private _unsubscribeAll: Subject<any>;

    constructor(
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder,
        private registerService: Register,
        private router: Router,
        private renderer2: Renderer2
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
        this.registerForm = this._formBuilder.group({
            username: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            password: ['', Validators.required],
            passwordConfirm: ['', [Validators.required, confirmPasswordValidator]]
        });

        // Update the validity of the 'passwordConfirm' field
        // when the 'password' field changes
        this.registerForm.get('password').valueChanges
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.registerForm.get('passwordConfirm').updateValueAndValidity();
            });
    }

    ngAfterViewInit(): void {
        this.resetRegisterForm();
        this.renderer2.selectRootElement('#username').focus();
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    register() {
        this.registerService.save({
            login: this.registerForm.controls.username.value,
            email: this.registerForm.controls.email.value,
            password: this.registerForm.controls.password.value,
            langKey: 'en'
        }).subscribe(
            () => {
                this.resetRegisterForm();
                this.router.navigate(['pages', 'auth', 'mail-confirm'], {
                    queryParams: {
                        title: 'Your user account has been activated.',
                        subtitle: `<p>A confirmation e-mail has been sent to <b>${this.registerForm.controls.email.value}</b>.</p>
                                   <p>Check your inbox and click on the "Confirm my email" link to confirm your email address.</p>`,
                        message: 'Go back to home page',
                        messageLink: ''
                    }
                });
            },
            response => this.processError(response)
        );
    }

    private processError(response: HttpErrorResponse) {
        if (response.status === 400 && response.error.type === LOGIN_ALREADY_USED_TYPE) {
            this.registerForm.setErrors({ 'errorUserExists': true });
        } else if (response.status === 400 && response.error.type === EMAIL_ALREADY_USED_TYPE) {
            this.registerForm.setErrors({ 'errorEmailExists': true });
        } else {
            this.registerForm.setErrors({ 'error': true });
        }
    }

    private resetRegisterForm() {
        setTimeout(() => {
            this.registerForm.markAsPristine();
            this.registerForm.reset({});
            this.registerForm.setErrors(null);
            this.registerForm.controls.username.setErrors(null);
            this.registerForm.controls.email.setErrors(null);
            this.registerForm.controls.password.setErrors(null);
            this.registerForm.controls.passwordConfirm.setErrors(null);
        });
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
