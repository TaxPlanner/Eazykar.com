import { NgModule } from '@angular/core';

import { Login2Module } from './authentication/login-2/login-2.module';
import { Register2Module } from './authentication/register-2/register-2.module';
import { ForgotPassword2Module } from './authentication/forgot-password-2/forgot-password-2.module';
import { ResetPassword2Module } from './authentication/reset-password-2/reset-password-2.module';
import { MailConfirmModule } from './authentication/mail-confirm/mail-confirm.module';
// import { ComingSoonModule } from './coming-soon/coming-soon.module';
// import { Error404Module } from './errors/404/error-404.module';
// import { Error500Module } from './errors/500/error-500.module';
// import { InvoiceModernModule } from './invoices/modern/modern.module';
// import { InvoiceCompactModule } from './invoices/compact/compact.module';
// import { MaintenanceModule } from './maintenance/maintenence.module';
import { PricingModule } from './pricing/pricing.module';
// import { ProfileModule } from './profile/profile.module';
// import { SearchClassicModule } from './search/classic/search-classic.module';
// import { SearchModernModule } from './search/modern/search-modern.module';
// import { FaqModule } from './faq/faq.module';
// import { KnowledgeBaseModule } from './knowledge-base/knowledge-base.module';

@NgModule({
    imports: [
        // Authentication
        Login2Module,
        Register2Module,
        ForgotPassword2Module,
        ResetPassword2Module,
        MailConfirmModule,

        // // Coming-soon
        // ComingSoonModule,
        //
        // // Errors
        // Error404Module,
        // Error500Module,
        //
        // // Invoices
        // InvoiceModernModule,
        // InvoiceCompactModule,
        //
        // // Maintenance
        // MaintenanceModule,

        // Pricing
        PricingModule

        // // Profile
        // ProfileModule,
        //
        // // Search
        // SearchClassicModule,
        // SearchModernModule,
        //
        // // Faq
        // FaqModule,
        //
        // // Knowledge base
        // KnowledgeBaseModule
    ]
})
export class PagesModule {

}
