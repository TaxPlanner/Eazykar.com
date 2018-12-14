import { Route } from '@angular/router';

import { EzkrMetricsMonitoringComponent } from './metrics.component';

export const metricsRoute: Route = {
    path: 'ezkr-metrics',
    component: EzkrMetricsMonitoringComponent,
    data: {
        pageTitle: 'metrics.title'
    }
};
