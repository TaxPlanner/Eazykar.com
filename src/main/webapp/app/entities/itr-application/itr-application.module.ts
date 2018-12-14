import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';
import { EazykarAdminModule } from 'app/admin/admin.module';
import {
    ItrApplicationComponent,
    ItrApplicationDetailComponent,
    ItrApplicationUpdateComponent,
    ItrApplicationDeletePopupComponent,
    ItrApplicationDeleteDialogComponent,
    itrApplicationRoute,
    itrApplicationPopupRoute
} from './';

const ENTITY_STATES = [...itrApplicationRoute, ...itrApplicationPopupRoute];

@NgModule({
    imports: [EazykarSharedModule, EazykarAdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        ItrApplicationComponent,
        ItrApplicationDetailComponent,
        ItrApplicationUpdateComponent,
        ItrApplicationDeleteDialogComponent,
        ItrApplicationDeletePopupComponent
    ],
    entryComponents: [
        ItrApplicationComponent,
        ItrApplicationUpdateComponent,
        ItrApplicationDeleteDialogComponent,
        ItrApplicationDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarItrApplicationModule {}
