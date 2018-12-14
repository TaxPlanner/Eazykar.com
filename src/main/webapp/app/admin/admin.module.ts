import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';
import { EazykarSharedModule } from 'app/shared';
import { EntityAuditModule } from './entity-audit/entity-audit.module';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
    adminState,
    AuditsComponent,
    UserMgmtComponent,
    UserMgmtDetailComponent,
    UserMgmtUpdateComponent,
    UserMgmtDeleteDialogComponent,
    LogsComponent,
    EzkrMetricsMonitoringModalComponent,
    EzkrMetricsMonitoringComponent,
    EzkrHealthModalComponent,
    EzkrHealthCheckComponent,
    EzkrConfigurationComponent,
    EzkrDocsComponent
} from './';

@NgModule({
    imports: [
        EazykarSharedModule,
        RouterModule.forChild(adminState),
        EntityAuditModule,
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        UserMgmtComponent,
        UserMgmtDetailComponent,
        UserMgmtUpdateComponent,
        UserMgmtDeleteDialogComponent,
        LogsComponent,
        EzkrConfigurationComponent,
        EzkrHealthCheckComponent,
        EzkrHealthModalComponent,
        EzkrDocsComponent,
        EzkrMetricsMonitoringComponent,
        EzkrMetricsMonitoringModalComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    entryComponents: [UserMgmtDeleteDialogComponent, EzkrHealthModalComponent, EzkrMetricsMonitoringModalComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAdminModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
