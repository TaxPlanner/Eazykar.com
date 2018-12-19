import { Routes } from '@angular/router';

export const fuseRoutes: Routes = [
    // {
    //     path        : 'apps',
    //     loadChildren: './apps/apps.module#AppsModule'
    // },
    {
        path        : 'pages',
        loadChildren: './pages/pages.module#PagesModule'
    },
    // {
    //     path        : 'ui',
    //     loadChildren: './ui/ui.module#UIModule'
    // },
];

