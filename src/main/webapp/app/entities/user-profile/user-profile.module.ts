import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';
import { EazykarAdminModule } from 'app/admin/admin.module';
import {
    UserProfileComponent,
    UserProfileDetailComponent,
    UserProfileUpdateComponent,
    UserProfileDeletePopupComponent,
    UserProfileDeleteDialogComponent,
    userProfileRoute,
    userProfilePopupRoute
} from './';

const ENTITY_STATES = [...userProfileRoute, ...userProfilePopupRoute];

@NgModule({
    imports: [EazykarSharedModule, EazykarAdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        UserProfileComponent,
        UserProfileDetailComponent,
        UserProfileUpdateComponent,
        UserProfileDeleteDialogComponent,
        UserProfileDeletePopupComponent
    ],
    entryComponents: [UserProfileComponent, UserProfileUpdateComponent, UserProfileDeleteDialogComponent, UserProfileDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarUserProfileModule {}
