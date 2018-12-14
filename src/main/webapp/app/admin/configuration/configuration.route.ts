import { Route } from '@angular/router';

import { EzkrConfigurationComponent } from './configuration.component';

export const configurationRoute: Route = {
    path: 'ezkr-configuration',
    component: EzkrConfigurationComponent,
    data: {
        pageTitle: 'configuration.title'
    }
};
