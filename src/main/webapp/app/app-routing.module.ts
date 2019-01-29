import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DEBUG_INFO_ENABLED } from './app.constants';
import { errorRoute } from './layouts';

const LAYOUT_ROUTES: Routes = [/*navbarRoute, */...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                ...LAYOUT_ROUTES,
                {
                    path: 'pages',
                    loadChildren: './main/pages/pages.module#PagesModule'
                }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class EazykarAppRoutingModule {
}
