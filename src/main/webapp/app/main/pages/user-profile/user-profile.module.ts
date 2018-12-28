import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {
    MatButtonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatSnackBarModule,
    MatStepperModule,
    MatTabsModule
} from '@angular/material';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserProfileComponent } from 'app/main/pages/user-profile/user-profile.component';
import { UserRouteAccessService } from 'app/core';

const routes: Routes = [
    {
        path: 'user-profile',
        component: UserProfileComponent,
        data: {
            authorities: ['ROLE_USER']
        },
        canActivate: [UserRouteAccessService]
    }
];

@NgModule({
    declarations: [
        UserProfileComponent
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

        FuseSharedModule
    ]
})
export class UserProfileModule {
}
