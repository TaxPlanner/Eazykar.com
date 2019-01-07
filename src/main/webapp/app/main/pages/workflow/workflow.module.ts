import { NgModule } from '@angular/core';
import {
    MatButtonModule,
    MatDatepickerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule
} from '@angular/material';
import { RouterModule, Routes } from '@angular/router';
import { FuseSidebarModule } from 'app/@fuse/components';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserRouteAccessService } from 'app/core';
import { PricingModule } from 'app/main/pages/pricing/pricing.module';
import { WorkflowComponent } from 'app/main/pages/workflow/workflow.component';
import { EazykarSharedModule } from 'app/shared';
import { InformationGatheringComponent } from './information-gathering/information-gathering.component';
import { OtherIncomeComponent } from './information-gathering/other-income/other-income.component';
import { DocumentDialogComponent } from './information-gathering/salary-information/document-dialog/document-dialog.component';
import { SalaryInformationDialogComponent } from './information-gathering/salary-information/salary-information-dialog/salary-information-dialog.component';
import { SalaryInformationComponent } from './information-gathering/salary-information/salary-information.component';
import { HousePropertyComponent } from './information-gathering/house-property/house-property.component';

const routes: Routes = [
    {
        path: 'workflow',
        component: WorkflowComponent,
        data: {
            authorities: ['ROLE_USER']
        },
        canActivate: [UserRouteAccessService]
    }
];

@NgModule({
    declarations: [
        WorkflowComponent,
        InformationGatheringComponent,
        SalaryInformationComponent,
        SalaryInformationDialogComponent,
        DocumentDialogComponent,
        OtherIncomeComponent,
        HousePropertyComponent
    ],
    imports: [
        RouterModule.forChild(routes),
        EazykarSharedModule,

        MatButtonModule,
        MatFormFieldModule,
        MatIconModule,
        MatInputModule,
        MatSelectModule,
        MatStepperModule,
        MatDatepickerModule,
        MatTabsModule,
        MatTableModule,
        MatProgressSpinnerModule,
        MatSnackBarModule,
        MatSlideToggleModule,
        MatDialogModule,

        FuseSharedModule,
        FuseSidebarModule,

        PricingModule
    ],
    entryComponents: [
        SalaryInformationDialogComponent,
        DocumentDialogComponent
    ]
})
export class WorkflowModule {
}
