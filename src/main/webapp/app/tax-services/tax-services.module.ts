import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { TAX_SERVICES_ROUTE, TaxServicesComponent } from './';
import { Quote1Component } from './quote1/quote1.component';
import { Quote2Component } from './quote2/quote2.component';
import { Quote3Component } from './quote3/quote3.component';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forRoot([TAX_SERVICES_ROUTE], { useHash: true })
    ],
    declarations: [
        TaxServicesComponent,
        Quote1Component,
        Quote2Component,
        Quote3Component
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppTaxServicesModule {
}
