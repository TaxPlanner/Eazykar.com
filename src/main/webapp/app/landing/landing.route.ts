import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { LandingComponent } from './';

export const LANDING_ROUTE: Route = {
  path: 'landing',
  component: LandingComponent,
  data: {
    authorities: [],
    pageTitle: 'landing.title'
  },
  canActivate: [UserRouteAccessService]
};
