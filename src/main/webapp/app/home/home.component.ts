import { Component, OnInit } from '@angular/core';
import { FuseConfigService } from 'app/@fuse/services/config.service';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';

import { Account, Principal } from 'app/core';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    selector: 'ezkr-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent implements OnInit {
    account: Account;

    constructor(private principal: Principal,
                private _fuseConfigService: FuseConfigService,
                private eventManager: JhiEventManager) {
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

    ngOnInit() {
        // todo: check for /pages/auth routes (e.g. login-2, register-2)
        if (!this.isAuthenticated()) {
            if (DEBUG_INFO_ENABLED) {
                window.location.href = 'http://localhost:8080/site/index.html';
            } else {
                window.location.href = '/site/index.html';
            }
        }
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.principal.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    // login() {
    //     this.modalRef = this.loginModalService.open();
    // }
}
