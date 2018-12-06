import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { LoginComponent } from './login.component';

export const LOGIN_ROUTE: Route = {
    path: 'sign-in-login',
    component: LoginComponent,
    data: {
        authorities: [],
        pageTitle: 'login.title'
    },
    canActivate: [UserRouteAccessService]
};
