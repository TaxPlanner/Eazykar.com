import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { TAX_SERVICES_ROUTE, TaxServicesComponent } from './';

@NgModule({
    imports: [
      EazykarSharedModule,
      RouterModule.forRoot([ TAX_SERVICES_ROUTE ], { useHash: true })
    ],
    declarations: [
      TaxServicesComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppTaxServicesModule {}
