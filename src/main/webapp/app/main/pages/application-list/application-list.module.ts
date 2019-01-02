import { NgModule } from '@angular/core';
import {
    MatButtonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule
} from '@angular/material';
import { RouterModule, Routes } from '@angular/router';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserRouteAccessService } from 'app/core';
import { ApplicationListComponent } from 'app/main/pages/application-list/application-list.component';

const routes: Routes = [
    {
        path: 'application-list',
        component: ApplicationListComponent,
        data: {
            authorities: ['ROLE_CA', 'ROLE_CA_MANAGER']
        },
        canActivate: [UserRouteAccessService]
    }
];

@NgModule({
    declarations: [
        ApplicationListComponent,
    ],
    imports: [
        RouterModule.forChild(routes),

        MatButtonModule,
        MatFormFieldModule,
        MatIconModule,
        MatInputModule,
        MatSelectModule,
        MatStepperModule,
        MatDatepickerModule,
        MatTabsModule,
        MatProgressSpinnerModule,
        MatSnackBarModule,
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,

        FuseSharedModule
    ]
})
export class ApplicationListModule {
}
