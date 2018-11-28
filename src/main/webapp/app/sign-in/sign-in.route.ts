import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { SignInComponent } from './';

export const SIGN_IN_ROUTE: Route = {
  path: 'sign-in',
  component: SignInComponent,
  data: {
    authorities: [],
    pageTitle: 'sign-in.title'
  },
  canActivate: [UserRouteAccessService]
};
