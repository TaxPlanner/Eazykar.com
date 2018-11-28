import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { USER_DASHBOARD_ROUTE, UserDashboardComponent } from './';

@NgModule({
    imports: [
      EazykarSharedModule,
      RouterModule.forRoot([ USER_DASHBOARD_ROUTE ], { useHash: true })
    ],
    declarations: [
      UserDashboardComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppUserDashboardModule {}
