import { NgModule } from '@angular/core';
import { MatButtonModule, MatCardModule, MatDialogModule, MatDividerModule, MatSnackBarModule } from '@angular/material';
import { RouterModule } from '@angular/router';

import { FuseSharedModule } from 'app/@fuse/shared.module';

import { PricingStyle1Component } from 'app/main/pages/pricing/style-1/style-1.component';
import { PaymentDialogComponent } from './style-1/payment-dialog/payment-dialog.component';

const routes = [
    {
        path     : 'pricing/style-1',
        component: PricingStyle1Component
    }
];

@NgModule({
    declarations: [
        PricingStyle1Component,
        PaymentDialogComponent
    ],
    exports: [
        PricingStyle1Component,
        PaymentDialogComponent
    ],
    imports     : [
        RouterModule.forChild(routes),

        MatButtonModule,
        MatDividerModule,
        MatDialogModule,
        MatCardModule,
        MatSnackBarModule,

        FuseSharedModule
    ],
    entryComponents: [
        PaymentDialogComponent
    ]
})
export class PricingModule
{
}
