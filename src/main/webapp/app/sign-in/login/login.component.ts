import { Component, ElementRef, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { LoginService, StateStorageService } from 'app/core';
import { Router } from '@angular/router';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    selector: 'ezkr-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

    authenticationError: boolean;

    password: string;
    rememberMe: boolean;
    username: string;

    success: boolean;

    @ViewChild('emailInput') emailInput: ElementRef;

    constructor(private eventManager: JhiEventManager,
                private loginService: LoginService,
                private stateStorageService: StateStorageService,
                private router: Router) {
    }

    ngOnInit() {
        this.success = false;
        this.emailInput.nativeElement.focus();
    }

    login() {
        this.loginService
            .login({
                username: this.username,
                password: this.password,
                rememberMe: this.rememberMe
            })
            .then(() => {
                this.authenticationError = false;
                if (this.router.url === '/register' || /^\/activate\//.test(this.router.url) || /^\/reset\//.test(this.router.url)) {
                    this.router.navigate(['']);
                }

                this.eventManager.broadcast({
                    name: 'authenticationSuccess',
                    content: 'Sending Authentication Success'
                });

                // previousState was set in the authExpiredInterceptor before being redirected to login modal.
                // since login is successful, go to stored previousState and clear previousState
                const redirect = this.stateStorageService.getUrl();
                if (redirect) {
                    this.stateStorageService.storeUrl(null);
                    this.router.navigate([redirect]);
                } else {
                    this.router.navigate(['user-dashboard']);
                }
            })
            .catch(() => {
                this.authenticationError = true;
            });
    }

    requestResetPassword() {
        this.router.navigate(['/reset', 'request']);
    }

}
