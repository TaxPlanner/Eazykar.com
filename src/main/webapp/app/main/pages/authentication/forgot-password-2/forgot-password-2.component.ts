import { AfterViewInit, Component, OnInit, Renderer2, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { FuseConfigService } from 'app/@fuse/services/config.service';
import { fuseAnimations } from 'app/@fuse/animations';
import { PasswordResetInitService } from 'app/account';
import { EMAIL_NOT_FOUND_TYPE } from 'app/shared';
import { Router } from '@angular/router';

@Component({
    selector: 'forgot-password-2',
    templateUrl: './forgot-password-2.component.html',
    styleUrls: ['./forgot-password-2.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class ForgotPassword2Component implements OnInit, AfterViewInit {

    forgotPasswordForm: FormGroup;

    constructor(private passwordResetInitService: PasswordResetInitService,
                private _fuseConfigService: FuseConfigService,
                private _formBuilder: FormBuilder,
                private router: Router,
                private renderer2: Renderer2) {

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
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        this.forgotPasswordForm = this._formBuilder.group({
            email: ['', [Validators.required, Validators.email]]
        });
    }

    ngAfterViewInit(): void {
        setTimeout(() => {
            this.renderer2.selectRootElement('#email').focus();
        });
    }

    requestReset() {

        this.passwordResetInitService.save(this.forgotPasswordForm.controls.email.value).subscribe(
            () => {

                this.router.navigate(['pages', 'auth', 'mail-confirm'], {
                    queryParams: {
                        title: 'Check your email!',
                        subtitle: `<p>A password reset e-mail has been sent to <b>${this.forgotPasswordForm.controls.email.value}</b>.</p>
                                   <p>Check your inbox and click on the "Reset my password" link to set a new password.</p>`,
                        message: 'Go back to sign in page',
                        messageLink: '/pages/auth/login-2'
                    }
                });
            },
            response => {

                if (response.status === 400 && response.error.type === EMAIL_NOT_FOUND_TYPE) {
                    this.forgotPasswordForm.setErrors({ errorEmailNotExists: true });
                } else {
                    this.forgotPasswordForm.setErrors({ error: true });
                }
            }
        );
    }
}
