import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';

import {
    HousePropertyComponent,
    HousePropertyDetailComponent,
    HousePropertyUpdateComponent,
    HousePropertyDeletePopupComponent,
    HousePropertyDeleteDialogComponent,
    housePropertyRoute,
    housePropertyPopupRoute
} from './';

const ENTITY_STATES = [...housePropertyRoute, ...housePropertyPopupRoute];

@NgModule({
    imports: [EazykarSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        HousePropertyComponent,
        HousePropertyDetailComponent,
        HousePropertyUpdateComponent,
        HousePropertyDeleteDialogComponent,
        HousePropertyDeletePopupComponent
    ],
    entryComponents: [
        HousePropertyComponent,
        HousePropertyUpdateComponent,
        HousePropertyDeleteDialogComponent,
        HousePropertyDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarHousePropertyModule {}
