import { AfterViewInit, Component, OnInit, Renderer2, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';

import { FuseConfigService } from '../../../../@fuse/services/config.service';
import { fuseAnimations } from '../../../../@fuse/animations';
import { LoginService, StateStorageService } from 'app/core';
import { Router } from '@angular/router';
import { JhiEventManager } from 'ng-jhipster';
import { log } from 'util';

@Component({
    selector: 'login-2',
    templateUrl: './login-2.component.html',
    styleUrls: ['./login-2.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class Login2Component implements OnInit, AfterViewInit {
    loginForm: FormGroup;

    authenticationError: boolean;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {FormBuilder} _formBuilder
     * @param {JhiEventManager} eventManager
     * @param {LoginService} loginService
     * @param {StateStorageService} stateStorageService
     * @param {Router} router
     * @param {Renderer2} renderer2
     */
    constructor(
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder,
        private eventManager: JhiEventManager,
        private loginService: LoginService,
        private stateStorageService: StateStorageService,
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
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        this.loginForm = this._formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required],
            rememberMe: ['']
        });
    }

    ngAfterViewInit(): void {
        setTimeout(() => {
            this.renderer2.selectRootElement('#username').focus();
        });
    }

    login() {
        this.loginService
            .login({
                username: this.loginForm.controls.username.value,
                password: this.loginForm.controls.password.value,
                rememberMe: this.loginForm.controls.rememberMe.value
            })
            .then(() => {
                this.authenticationError = false;
                // this.loginForm.setErrors({'authenticationError': false});
                if (/^\/register/.test(this.router.url) || /^\/activate\//.test(this.router.url) || /^\/reset\//.test(this.router.url) || true) {
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
                }
            })
            .catch(() => {
                this.authenticationError = true;
                this.loginForm.setErrors({ 'authenticationError': true });
            });
    }

}
