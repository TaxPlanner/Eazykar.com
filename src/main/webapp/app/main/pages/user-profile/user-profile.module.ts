import { NgModule } from '@angular/core';
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
import { RouterModule, Routes } from '@angular/router';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserRouteAccessService } from 'app/core';
import { PricingModule } from 'app/main/pages/pricing/pricing.module';
import { UserProfileComponent } from 'app/main/pages/user-profile/user-profile.component';
import { PersonalInformationComponent } from './personal-information/personal-information.component';
import { AddressInformationComponent } from './address-information/address-information.component';
import { KeyInformationComponent } from './key-information/key-information.component';

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
        UserProfileComponent,
        PersonalInformationComponent,
        AddressInformationComponent,
        KeyInformationComponent
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

        FuseSharedModule,
        PricingModule
    ]
})
export class UserProfileModule {
}
