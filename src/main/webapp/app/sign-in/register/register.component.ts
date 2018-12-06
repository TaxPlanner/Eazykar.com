import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild, ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Register } from 'app/account';
import { EMAIL_ALREADY_USED_TYPE, LOGIN_ALREADY_USED_TYPE } from 'app/shared';

@Component({
    selector: 'ezkr-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit, AfterViewInit {

    confirmPassword: string;
    doNotMatch: string;
    error: string;
    errorEmailExists: string;
    errorUserExists: string;
    registerAccount: any;
    success: boolean;

    @ViewChild('registerForm') registerForm: NgForm;

    constructor(private registerService: Register,
                private renderer2: Renderer2,
                private router: Router) {
        this.confirmPassword = '';
    }

    ngOnInit() {
        this.registerAccount = {};
    }

    ngAfterViewInit(): void {
        this.resetRegisterForm();
        this.renderer2.selectRootElement('#regUsername').focus();
    }

    requestResetPassword() {
        this.router.navigate(['/reset', 'request']);
    }

    register() {
        if (this.registerAccount.password !== this.confirmPassword) {
            this.doNotMatch = 'ERROR';
        } else {
            this.doNotMatch = null;
            this.error = null;
            this.errorUserExists = null;
            this.errorEmailExists = null;
            this.registerAccount.langKey = 'en';
            this.registerService.save(this.registerAccount).subscribe(
                () => {
                    this.success = true;
                    this.resetRegisterForm();
                },
                response => this.processError(response)
            );
        }
    }

    private processError(response: HttpErrorResponse) {
        this.success = null;
        if (response.status === 400 && response.error.type === LOGIN_ALREADY_USED_TYPE) {
            this.errorUserExists = 'ERROR';
        } else if (response.status === 400 && response.error.type === EMAIL_ALREADY_USED_TYPE) {
            this.errorEmailExists = 'ERROR';
        } else {
            this.error = 'ERROR';
        }
    }

    private resetRegisterForm() {
        this.registerAccount = {};
        this.registerForm.resetForm({});
    }

}
