import { Route } from '@angular/router';

import { EzkrDocsComponent } from './docs.component';

export const docsRoute: Route = {
    path: 'docs',
    component: EzkrDocsComponent,
    data: {
        pageTitle: 'global.menu.admin.apidocs'
    }
};
