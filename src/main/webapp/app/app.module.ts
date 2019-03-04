import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE, MAT_SNACK_BAR_DEFAULT_OPTIONS, MatButtonModule, MatIconModule } from '@angular/material';
import { MatMomentDateModule, MomentDateAdapter } from '@angular/material-moment-adapter';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { EazykarCoreModule } from 'app/core';
import { EazykarSharedModule } from 'app/shared';
import * as moment from 'moment';
import { NgJhipsterModule } from 'ng-jhipster';
import { Ng2Webstorage } from 'ngx-webstorage';
import { FuseProgressBarModule, FuseSidebarModule } from './@fuse/components';
import { FuseModule } from './@fuse/fuse.module';
import { FuseSharedModule } from './@fuse/shared.module';
import { EazykarAccountModule } from './account/account.module';
import { EazykarAppRoutingModule } from './app-routing.module';
import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';

import { AuthInterceptor } from './blocks/interceptor/auth.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import { fuseConfig } from './fuse-config';
import { EazykarHomeModule } from './home/home.module';
import { LayoutModule } from './layout/layout.module';
// jhipster-needle-angular-add-module-import
import { ErrorComponent, EzkrMainComponent, PageRibbonComponent } from './layouts';
import './vendor.ts';

export const MY_FORMATS = {
    parse: {
        dateInput: 'DD-MM-YYYY'
    },
    display: {
        dateInput: 'DD-MM-YYYY',
        monthYearLabel: 'MMM YYYY',
        dateA11yLabel: 'DD-MM-YYYY',
        monthYearA11yLabel: 'MMMM YYYY'
    }
};

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

        LayoutModule
    ],
    declarations: [EzkrMainComponent,  ErrorComponent, PageRibbonComponent],
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
        },
        // `MomentDateAdapter` can be automatically provided by importing `MomentDateModule` in your
        // application's root module. We provide it at the component level here, due to limitations of
        // our example generation script.
        { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
        { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS }
    ],
    bootstrap: [EzkrMainComponent]
})
export class EazykarAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
    }
}
