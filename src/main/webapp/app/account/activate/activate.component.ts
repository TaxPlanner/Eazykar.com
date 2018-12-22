import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { LoginModalService } from 'app/core';
import { ActivateService } from './activate.service';

@Component({
    selector: 'ezkr-activate',
    templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit {
    error: string;
    success: string;

    constructor(private activateService: ActivateService,
                private loginModalService: LoginModalService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit() {
        this.route.queryParams.subscribe(params => {
            this.activateService.get(params['key']).subscribe(
                () => {
                    this.error = null;
                    this.success = 'OK';
                    this.router.navigate(['pages', 'auth', 'mail-confirm'], {
                        queryParams: {
                            title: 'Email Verification Complete',
                            subtitle: 'Your user account has been activated.',
                            message: `Let's sign in`,
                            messageLink: '/pages/auth/login-2'
                        }
                    });
                },
                () => {
                    this.success = null;
                    this.error = 'ERROR';
                    this.router.navigate(['pages', 'auth', 'mail-confirm'], {
                        queryParams: {
                            title: 'Your user could not be activated.',
                            subtitle: '',
                            message: 'Please use the registration page to sign up.',
                            messageLink: '/pages/auth/registration-2'
                        }
                    });
                }
            );
        });
    }

    login() {
        this.router.navigate(['sign-in', 'sign-in-login']);
    }
}
