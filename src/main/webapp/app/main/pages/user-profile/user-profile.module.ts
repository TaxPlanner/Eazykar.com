import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {
    MatButtonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    MatStepperModule,
    MatTabsModule
} from '@angular/material';

import { FuseSharedModule } from 'app/@fuse/shared.module';
import { UserProfileComponent } from 'app/main/pages/user-profile/user-profile.component';

const routes: Routes = [
    {
        path: 'user-profile',
        component: UserProfileComponent
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

        FuseSharedModule
    ]
})
export class UserProfileModule {
}
