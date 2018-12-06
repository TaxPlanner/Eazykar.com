import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { SignInComponent } from './';
import { LOGIN_ROUTE } from './login/login.route';
import { REGISTER_ROUTE } from './register/register.route';

export const SIGN_IN_ROUTE: Route = {
    path: 'sign-in',
    component: SignInComponent,
    data: {
        authorities: [],
        pageTitle: 'sign-in.title'
    },
    canActivate: [UserRouteAccessService],
    children: [LOGIN_ROUTE, REGISTER_ROUTE]
};
