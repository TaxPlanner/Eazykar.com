import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { RegisterComponent } from './register.component';

export const REGISTER_ROUTE: Route = {
    path: 'sign-in-register',
    component: RegisterComponent,
    data: {
        authorities: [],
        pageTitle: 'register.title'
    },
    canActivate: [UserRouteAccessService]
};
