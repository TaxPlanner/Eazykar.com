import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';
import { EazykarAdminModule } from 'app/admin/admin.module';
import {
    UserPlanComponent,
    UserPlanDetailComponent,
    UserPlanUpdateComponent,
    UserPlanDeletePopupComponent,
    UserPlanDeleteDialogComponent,
    userPlanRoute,
    userPlanPopupRoute
} from './';

const ENTITY_STATES = [...userPlanRoute, ...userPlanPopupRoute];

@NgModule({
    imports: [EazykarSharedModule, EazykarAdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        UserPlanComponent,
        UserPlanDetailComponent,
        UserPlanUpdateComponent,
        UserPlanDeleteDialogComponent,
        UserPlanDeletePopupComponent
    ],
    entryComponents: [UserPlanComponent, UserPlanUpdateComponent, UserPlanDeleteDialogComponent, UserPlanDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarUserPlanModule {}
