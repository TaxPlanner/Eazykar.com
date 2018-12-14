import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { EazykarUserProfileModule } from './user-profile/user-profile.module';
import { EazykarItrApplicationModule } from './itr-application/itr-application.module';
import { EazykarPlanModule } from './plan/plan.module';
import { EazykarUserPlanModule } from './user-plan/user-plan.module';
/* jhipster-needle-add-entity-module-import */

@NgModule({
    // prettier-ignore
    imports: [
        EazykarUserProfileModule,
        EazykarItrApplicationModule,
        EazykarPlanModule,
        EazykarUserPlanModule,
        /* jhipster-needle-add-entity-module   */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarEntityModule {}
