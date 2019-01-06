import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';

import {
    SalaryInformationComponent,
    SalaryInformationDetailComponent,
    SalaryInformationUpdateComponent,
    SalaryInformationDeletePopupComponent,
    SalaryInformationDeleteDialogComponent,
    salaryInformationRoute,
    salaryInformationPopupRoute
} from './';

const ENTITY_STATES = [...salaryInformationRoute, ...salaryInformationPopupRoute];

@NgModule({
    imports: [EazykarSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SalaryInformationComponent,
        SalaryInformationDetailComponent,
        SalaryInformationUpdateComponent,
        SalaryInformationDeleteDialogComponent,
        SalaryInformationDeletePopupComponent
    ],
    entryComponents: [
        SalaryInformationComponent,
        SalaryInformationUpdateComponent,
        SalaryInformationDeleteDialogComponent,
        SalaryInformationDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarSalaryInformationModule {}
