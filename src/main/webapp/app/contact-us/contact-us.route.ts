import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { ContactUsComponent } from './';

export const CONTACT_US_ROUTE: Route = {
  path: 'contact-us',
  component: ContactUsComponent,
  data: {
    authorities: [],
    pageTitle: 'contact-us.title'
  },
  canActivate: [UserRouteAccessService]
};
