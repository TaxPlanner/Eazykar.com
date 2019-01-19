import { NgModule } from '@angular/core';
import {
    MatButtonModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatTooltipModule
} from '@angular/material';
import { RouterModule, Routes } from '@angular/router';
import { FuseSidebarModule } from 'app/@fuse/components';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserRouteAccessService } from 'app/core';
import { ClientResolverService } from 'app/core/user/client-resolver.service';
import { PricingModule } from 'app/main/pages/pricing/pricing.module';
import { ApplicationListComponent } from 'app/main/pages/workflow/application-list/application-list.component';
import { WorkflowComponent } from 'app/main/pages/workflow/workflow.component';
import { EazykarSharedModule } from 'app/shared';
import { CapitalGainsComponent } from './information-gathering/capital-gains/capital-gains.component';
import { DeductionsComponent } from './information-gathering/deductions/deductions.component';
import { HousePropertyComponent } from './information-gathering/house-property/house-property.component';
import { InformationGatheringComponent } from './information-gathering/information-gathering.component';
import { OtherIncomeComponent } from './information-gathering/other-income/other-income.component';
import { DocumentDialogComponent } from './information-gathering/salary-information/document-dialog/document-dialog.component';
import { SalaryInformationDialogComponent } from './information-gathering/salary-information/salary-information-dialog/salary-information-dialog.component';
import { SalaryInformationComponent } from './information-gathering/salary-information/salary-information.component';

const routes: Routes = [
    {
        path: 'workflow',
        component: WorkflowComponent,
        data: {
            authorities: ['ROLE_USER']
        },
        canActivate: [UserRouteAccessService],
        resolve: {
            client: ClientResolverService
        }
    }
];

@NgModule({
    declarations: [
        WorkflowComponent,
        ApplicationListComponent,
        InformationGatheringComponent,
        SalaryInformationComponent,
        SalaryInformationDialogComponent,
        DocumentDialogComponent,
        OtherIncomeComponent,
        HousePropertyComponent,
        CapitalGainsComponent,
        DeductionsComponent
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
        MatPaginatorModule,
        MatSortModule,
        MatProgressSpinnerModule,
        MatSnackBarModule,
        MatSlideToggleModule,
        MatDialogModule,
        MatCheckboxModule,
        MatTooltipModule,

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
