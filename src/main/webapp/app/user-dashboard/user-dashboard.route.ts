import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { UserDashboardComponent } from './';

export const USER_DASHBOARD_ROUTE: Route = {
  path: 'user-dashboard',
  component: UserDashboardComponent,
  data: {
    authorities: [],
    pageTitle: 'user-dashboard.title'
  },
  canActivate: [UserRouteAccessService]
};
