import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { SIGN_IN_ROUTE, SignInComponent } from './';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forRoot([SIGN_IN_ROUTE], { useHash: true })
    ],
    declarations: [
        SignInComponent,
        LoginComponent,
        RegisterComponent
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppSignInModule {
}
