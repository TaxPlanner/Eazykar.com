import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { TaxKnowledgeComponent } from './';

export const TAX_KNOWLEDGE_ROUTE: Route = {
  path: 'tax-knowledge',
  component: TaxKnowledgeComponent,
  data: {
    authorities: [],
    pageTitle: 'tax-knowledge.title'
  },
  canActivate: [UserRouteAccessService]
};
