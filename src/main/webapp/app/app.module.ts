import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { Ng2Webstorage } from 'ngx-webstorage';
import { NgJhipsterModule } from 'ng-jhipster';
import * as moment from 'moment';

import { AuthInterceptor } from './blocks/interceptor/auth.interceptor';
import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import { EazykarSharedModule } from 'app/shared';
import { EazykarCoreModule } from 'app/core';
import { EazykarAppRoutingModule } from './app-routing.module';
import { EazykarHomeModule } from './home/home.module';
import { EazykarAccountModule } from './account/account.module';
import { EazykarAppTaxServicesModule } from 'app/main/pages/tax-services';
import { EazykarAppContactUsModule } from './contact-us/contact-us.module';
// jhipster-needle-angular-add-module-import
import { ActiveMenuDirective, ErrorComponent, EzkrMainComponent, FooterComponent, NavbarComponent, PageRibbonComponent } from './layouts';
import { MAT_SNACK_BAR_DEFAULT_OPTIONS, MatButtonModule, MatIconModule } from '@angular/material';
import { MatMomentDateModule } from '@angular/material-moment-adapter';
import { FuseSharedModule } from './@fuse/shared.module';
import { FuseProgressBarModule, FuseSidebarModule, FuseThemeOptionsModule } from './@fuse/components';
import { FuseModule } from './@fuse/fuse.module';
import { LayoutModule } from './layout/layout.module';
import { fuseConfig } from './fuse-config';
import { TranslateModule } from '@ngx-translate/core';

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        EazykarAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'ezkr', separator: '-' }),
        NgJhipsterModule.forRoot({
            // set below to true to make alerts look like toast
            alertAsToast: false,
            alertTimeout: 5000,
            i18nEnabled: false,
            defaultI18nLang: 'en'
        }),
        EazykarSharedModule.forRoot(),
        EazykarCoreModule,
        EazykarHomeModule,
        EazykarAccountModule,
        EazykarAppTaxServicesModule,
        EazykarAppContactUsModule,
        // jhipster-needle-angular-add-module

        TranslateModule.forRoot(),

        // Material moment date module
        MatMomentDateModule,

        // Material
        MatButtonModule,
        MatIconModule,

        // Fuse modules
        FuseModule.forRoot(fuseConfig),
        FuseProgressBarModule,
        FuseSharedModule,
        FuseSidebarModule,
        FuseThemeOptionsModule,

        LayoutModule
    ],
    declarations: [EzkrMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true
        },
        {
            provide: MAT_SNACK_BAR_DEFAULT_OPTIONS,
            useValue: { duration: 4000 }
        }
    ],
    bootstrap: [EzkrMainComponent]
})
export class EazykarAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
    }
}
