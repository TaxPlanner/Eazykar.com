import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { IUser, Principal, StateStorageService } from 'app/core';
import { UserPlanService } from 'app/main/pages/pricing/style-1/user-plan.service';
import { AddressService } from 'app/main/pages/user-profile/address-information/address.service';
import { KeyInformationService } from 'app/main/pages/user-profile/key-information/key-information.service';
import { UserProfileService } from 'app/main/pages/user-profile/user-profile.service';
import { IAddress } from 'app/shared/model/address.model';
import { IKeyInformation } from 'app/shared/model/key-information.model';
import { IUserPlan } from 'app/shared/model/user-plan.model';
import { IUserProfile } from 'app/shared/model/user-profile.model';
import * as _ from 'lodash';

@Injectable({ providedIn: 'root' })
export class WhereToNextService {

    constructor(private router: Router,
                private principal: Principal,
                private userPlanService: UserPlanService,
                private userProfileService: UserProfileService,
                private addressService: AddressService,
                private keyInformationService: KeyInformationService,
                private stateStorageService: StateStorageService) {

    }

    go() {

        if (this.principal.isAuthenticated()) {

            this.principal.identity()
                .then(account => {

                    if (_.includes(account.authorities, 'ROLE_CA_MANAGER')) {
                        console.log('Welcome CA MANAGER');
                        this.navigateToWorkflow(account, 1);

                    } else if (_.includes(account.authorities, 'ROLE_CA')) {
                        console.log('Welcome CA');
                        this.navigateToWorkflow(account, 1);

                    } else if (_.includes(account.authorities, 'ROLE_USER')) {
                        this.navigateToMyPlanOrNext(account);

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

    private navigateToMyPlanOrNext(account: IUser) {

        this.userPlanService
            .query({ 'userId.equals': account.id })
            .subscribe(
                (response: HttpResponse<IUserPlan[]>) => {
                    if (response && response.body && response.body.length > 0 && response.body[0].plan.active) {
                        // If user has a plan, load Personal Information tab
                        this.navigateToPersonalInformationOrNext(account);

                    } else {
                        // If user doesn't have an active plan, load My Plans tab
                        this.router.navigate(['pages', 'user-profile'], { queryParams: { selectedTabIndex: 3 } });
                    }
                },
                (res: HttpErrorResponse) => this.logErrorAndNavigateToHome(res)
            );

    }

    private navigateToPersonalInformationOrNext(account: IUser) {

        this.userProfileService
            .query({ 'userId.equals': account.id })
            .subscribe(
                (response: HttpResponse<IUserProfile[]>) => {
                    if (response && response.body && response.body.length > 0) {
                        // if user profile info exists check if address is entered
                        this.navigateToAddressInformationOrNext(account);
                    } else {
                        // navigate to personal information tab
                        this.router.navigate(['pages', 'user-profile'], { queryParams: { selectedTabIndex: 0 } });
                    }
                },
                (res: HttpErrorResponse) => this.logErrorAndNavigateToHome(res)
            );
    }

    private navigateToAddressInformationOrNext(account: IUser) {

        this.addressService
            .query({ 'userId.equals': account.id })
            .subscribe(
                (response: HttpResponse<IAddress[]>) => {
                    if (response && response.body && response.body.length > 0) {
                        // if address info exists check if key information is entered
                        this.navigateToKeyInformationOrNext(account);
                    } else {
                        // navigate to address information tab
                        this.router.navigate(['pages', 'user-profile'], { queryParams: { selectedTabIndex: 1 } });
                    }
                },
                (res: HttpErrorResponse) => this.logErrorAndNavigateToHome(res)
            );
    }

    private navigateToKeyInformationOrNext(account: IUser) {

        this.keyInformationService
            .query({ 'userId.equals': account.id })
            .subscribe(
                (response: HttpResponse<IKeyInformation[]>) => {
                    if (response && response.body && response.body.length > 0) {
                        // if key information exists navigate to My ITR
                        this.navigateToWorkflow(account);
                    } else {
                        // navigate to address information tab
                        this.router.navigate(['pages', 'user-profile'], { queryParams: { selectedTabIndex: 2 } });
                    }
                },
                (res: HttpErrorResponse) => this.logErrorAndNavigateToHome(res)
            );

    }

    private navigateToWorkflow(account: IUser, currentStep = 0) {
        this.router.navigate(['pages', 'workflow'], { queryParams: { currentStep } });
    }

    private logErrorAndNavigateToHome(res: HttpErrorResponse) {
        console.error(`Error: ${JSON.stringify(res)}`);
        this.router.navigate(['']);
    }
}
