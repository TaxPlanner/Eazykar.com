import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { LANDING_ROUTE, LandingComponent } from './';

@NgModule({
    imports: [
      EazykarSharedModule,
      RouterModule.forRoot([ LANDING_ROUTE ], { useHash: true })
    ],
    declarations: [
      LandingComponent,
    ],
    exports: [
      LandingComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppLandingModule {}
