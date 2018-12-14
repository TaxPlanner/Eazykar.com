import { Route } from '@angular/router';

import { EzkrHealthCheckComponent } from './health.component';

export const healthRoute: Route = {
    path: 'ezkr-health',
    component: EzkrHealthCheckComponent,
    data: {
        pageTitle: 'health.title'
    }
};
