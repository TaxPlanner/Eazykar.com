import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from './';
import { FuseSharedModule } from 'app/@fuse/shared.module';
import { SlideshowModule } from 'ng-simple-slideshow';
import { PricingModule } from 'app/main/pages/pricing/pricing.module';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forChild([HOME_ROUTE]),

        SlideshowModule,

        FuseSharedModule,
        PricingModule,
    ],
    declarations: [HomeComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarHomeModule {}
