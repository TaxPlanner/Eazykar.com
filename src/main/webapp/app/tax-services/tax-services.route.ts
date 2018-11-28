import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { TaxServicesComponent } from './';

export const TAX_SERVICES_ROUTE: Route = {
  path: 'tax-services',
  component: TaxServicesComponent,
  data: {
    authorities: [],
    pageTitle: 'tax-services.title'
  },
  canActivate: [UserRouteAccessService]
};
