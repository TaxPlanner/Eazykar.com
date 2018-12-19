import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { errorRoute, navbarRoute } from './layouts';
import { DEBUG_INFO_ENABLED } from './app.constants';
import { PagesModule } from './main/pages/pages.module';
import { EazykarAdminModule } from './admin/admin.module';

const LAYOUT_ROUTES: Routes = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                ...LAYOUT_ROUTES,
                {
                    path: 'pages',
                    loadChildren: () => PagesModule
                },
                {
                    path: 'admin',
                    loadChildren: () => EazykarAdminModule
                }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class EazykarAppRoutingModule {
}
