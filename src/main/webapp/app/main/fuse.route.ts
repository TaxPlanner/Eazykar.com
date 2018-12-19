import { Routes } from '@angular/router';
import { PagesModule } from 'app/main/pages/pages.module';

export const fuseRoutes: Routes = [
    // {
    //     path        : 'apps',
    //     loadChildren: () => AppsModule
    // },
    {
        path        : 'pages',
        loadChildren: () => PagesModule
    },
    // {
    //     path        : 'ui',
    //     loadChildren: () => UIModule
    // },
];

