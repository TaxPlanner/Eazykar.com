import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';

import {
    OtherIncomeComponent,
    OtherIncomeDetailComponent,
    OtherIncomeUpdateComponent,
    OtherIncomeDeletePopupComponent,
    OtherIncomeDeleteDialogComponent,
    otherIncomeRoute,
    otherIncomePopupRoute
} from './';

const ENTITY_STATES = [...otherIncomeRoute, ...otherIncomePopupRoute];

@NgModule({
    imports: [EazykarSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        OtherIncomeComponent,
        OtherIncomeDetailComponent,
        OtherIncomeUpdateComponent,
        OtherIncomeDeleteDialogComponent,
        OtherIncomeDeletePopupComponent
    ],
    entryComponents: [OtherIncomeComponent, OtherIncomeUpdateComponent, OtherIncomeDeleteDialogComponent, OtherIncomeDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarOtherIncomeModule {}
