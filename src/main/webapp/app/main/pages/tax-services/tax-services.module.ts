import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CarouselModule, MDBBootstrapModule } from 'angular-bootstrap-md';

import { EazykarSharedModule } from 'app/shared';

import { TAX_SERVICES_ROUTE, TaxServicesComponent } from './';
import { Quote1Component } from './quote1/quote1.component';
import { Quote2Component } from './quote2/quote2.component';
import { Quote3Component } from './quote3/quote3.component';
import { CarouselComponent } from './carousel/carousel.component';
import { Carousel2Component } from './carousel2/carousel2.component';
import { Carousel3Component } from './carousel3/carousel3.component';
import { PricingComponent } from './pricing/pricing.component';
import { Pricing2Component } from './pricing2/pricing2.component';
import { Pricing3Component } from './pricing3/pricing3.component';
import { Pricing4Component } from './pricing4/pricing4.component';
import { Carousel4Component } from './carousel4/carousel4.component';
import { Carousel5Component } from './carousel5/carousel5.component';
import { Carousel6Component } from './carousel6/carousel6.component';
import { HighlightsComponent } from './highlights/highlights.component';
import { ServicePillsComponent } from './service-pills/service-pills.component';
import { BlogsComponent } from './blogs/blogs.component';

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
        Carousel3Component,
        PricingComponent,
        Pricing2Component,
        Pricing3Component,
        Pricing4Component,
        Carousel4Component,
        Carousel5Component,
        Carousel6Component,
        HighlightsComponent,
        ServicePillsComponent,
        BlogsComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppTaxServicesModule {
}
