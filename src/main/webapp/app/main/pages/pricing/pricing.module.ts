import { NgModule } from '@angular/core';
import { MatButtonModule, MatCardModule, MatDialogModule, MatDividerModule } from '@angular/material';
import { RouterModule } from '@angular/router';

import { FuseSharedModule } from 'app/@fuse/shared.module';

import { PricingStyle1Component } from 'app/main/pages/pricing/style-1/style-1.component';
import { PricingStyle2Component } from 'app/main/pages/pricing/style-2/style-2.component';
import { PricingStyle3Component } from 'app/main/pages/pricing/style-3/style-3.component';
import { PaymentDialogComponent } from './style-1/payment-dialog/payment-dialog.component';

const routes = [
    {
        path     : 'pricing/style-1',
        component: PricingStyle1Component
    },
    {
        path     : 'pricing/style-2',
        component: PricingStyle2Component
    },
    {
        path     : 'pricing/style-3',
        component: PricingStyle3Component
    }
];

@NgModule({
    declarations: [
        PricingStyle1Component,
        PricingStyle2Component,
        PricingStyle3Component,
        PaymentDialogComponent
    ],
    exports: [
        PricingStyle1Component,
        PricingStyle2Component,
        PricingStyle3Component,
        PaymentDialogComponent
    ],
    imports     : [
        RouterModule.forChild(routes),

        MatButtonModule,
        MatDividerModule,
        MatDialogModule,
        MatCardModule,

        FuseSharedModule
    ],
    entryComponents: [
        PaymentDialogComponent
    ]
})
export class PricingModule
{
}
