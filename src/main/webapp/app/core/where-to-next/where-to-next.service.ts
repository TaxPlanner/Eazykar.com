import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Principal, StateStorageService } from 'app/core';
import * as _ from 'lodash';

@Injectable({ providedIn: 'root' })
export class WhereToNextService {

    constructor(private router: Router,
                private principal: Principal,
                private stateStorageService: StateStorageService) {

    }

    go() {

        if (this.principal.isAuthenticated()) {

            this.principal.identity()
                .then(account => {

                    if (_.includes(account.authorities, 'ROLE_CA_MANAGER')) {
                        console.log('Welcome CA MANAGER');
                        this.router.navigate(['pages', 'application-list']);

                    } else if (_.includes(account.authorities, 'ROLE_CA')) {
                        console.log('Welcome CA');
                        this.router.navigate(['pages', 'application-list']);

                    } else if (_.includes(account.authorities, 'ROLE_USER')) {
                        console.log('Welcome Client');
                        this.router.navigate(['pages', 'user-profile']);

                    } else {
                        // previousState was set in the authExpiredInterceptor before being redirected to login modal.
                        // since login is successful, go to stored previousState and clear previousState
                        const redirect = this.stateStorageService.getUrl();
                        if (redirect) {
                            this.stateStorageService.storeUrl(null);
                            this.router.navigate([redirect]);
                        }
                    }

                })
                .catch((err) => {
                    console.error(err);
                    this.router.navigate(['']);
                });

        } else {
            this.router.navigate(['']);
        }

    }
}
