import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
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
import { EazykarEntityModule } from './entities/entity.module';
import { EazykarAppTaxServicesModule } from './tax-services/tax-services.module';
import { EazykarAppTaxKnowledgeModule } from './tax-knowledge/tax-knowledge.module';
import { EazykarAppContactUsModule } from './contact-us/contact-us.module';
import { EazykarAppSignInModule } from './sign-in/sign-in.module';
import { EazykarAppUserProfileCombinedModule } from './user-profile-combined/user-profile-combined.module';
// jhipster-needle-angular-add-module-import
import { EzkrMainComponent, NavbarComponent, FooterComponent, PageRibbonComponent, ActiveMenuDirective, ErrorComponent } from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        EazykarAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'ezkr', separator: '-' }),
        NgJhipsterModule.forRoot({
            // set below to true to make alerts look like toast
            alertAsToast: false,
            alertTimeout: 5000,
            i18nEnabled: true,
            defaultI18nLang: 'en'
        }),
        EazykarSharedModule.forRoot(),
        EazykarCoreModule,
        EazykarHomeModule,
        EazykarAccountModule,
        EazykarAppTaxServicesModule,
        EazykarAppTaxKnowledgeModule,
        EazykarAppContactUsModule,
        EazykarAppSignInModule,
        EazykarAppUserProfileCombinedModule,
        // jhipster-needle-angular-add-module
        EazykarEntityModule
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
        }
    ],
    bootstrap: [EzkrMainComponent]
})
export class EazykarAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
    }
}
