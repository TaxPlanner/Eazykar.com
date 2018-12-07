import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CarouselModule, MDBBootstrapModule } from 'angular-bootstrap-md';

import { EazykarSharedModule } from '../shared';

import { TAX_SERVICES_ROUTE, TaxServicesComponent } from './';
import { Quote1Component } from './quote1/quote1.component';
import { Quote2Component } from './quote2/quote2.component';
import { Quote3Component } from './quote3/quote3.component';
import { CarouselComponent } from './carousel/carousel.component';
import { Carousel2Component } from './carousel2/carousel2.component';
import { Carousel3Component } from './carousel3/carousel3.component';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forRoot([TAX_SERVICES_ROUTE], { useHash: true }),
        MDBBootstrapModule.forRoot(),
        CarouselModule.forRoot()
    ],
    declarations: [
        TaxServicesComponent,
        Quote1Component,
        Quote2Component,
        Quote3Component,
        CarouselComponent,
        Carousel2Component,
        Carousel3Component
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppTaxServicesModule {
}
