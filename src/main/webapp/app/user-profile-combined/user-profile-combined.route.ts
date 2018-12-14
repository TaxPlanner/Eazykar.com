import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { UserProfileCombinedComponent } from './';

export const USER_PROFILE_COMBINED_ROUTE: Route = {
  path: 'user-profile-combined',
  component: UserProfileCombinedComponent,
  data: {
    authorities: [],
    pageTitle: 'user-profile-combined.title'
  },
  canActivate: [UserRouteAccessService]
};
