import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';
import {
    PlanComponent,
    PlanDetailComponent,
    PlanUpdateComponent,
    PlanDeletePopupComponent,
    PlanDeleteDialogComponent,
    planRoute,
    planPopupRoute
} from './';

const ENTITY_STATES = [...planRoute, ...planPopupRoute];

@NgModule({
    imports: [EazykarSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [PlanComponent, PlanDetailComponent, PlanUpdateComponent, PlanDeleteDialogComponent, PlanDeletePopupComponent],
    entryComponents: [PlanComponent, PlanUpdateComponent, PlanDeleteDialogComponent, PlanDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarPlanModule {}
