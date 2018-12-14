import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { USER_PROFILE_COMBINED_ROUTE, UserProfileCombinedComponent } from './';
import { SettingsComponent } from 'app/account';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forRoot([USER_PROFILE_COMBINED_ROUTE], { useHash: true })
    ],
    declarations: [
        UserProfileCombinedComponent,
        SettingsComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppUserProfileCombinedModule {
}
