import { NgModule } from '@angular/core';
import { ApplicationListModule } from 'app/main/pages/application-list/application-list.module';
import { TaxKnowledgeModule } from 'app/main/pages/tax-knowledge/tax-knowledge.module';
import { EazykarAppTaxServicesModule } from 'app/main/pages/tax-services';
import { UserProfileModule } from 'app/main/pages/user-profile/user-profile.module';
import { WorkflowModule } from 'app/main/pages/workflow/workflow.module';
import { EazykarSharedModule } from 'app/shared';
import { ForgotPassword2Module } from './authentication/forgot-password-2/forgot-password-2.module';

import { Login2Module } from './authentication/login-2/login-2.module';
import { MailConfirmModule } from './authentication/mail-confirm/mail-confirm.module';
import { Register2Module } from './authentication/register-2/register-2.module';
import { ResetPassword2Module } from './authentication/reset-password-2/reset-password-2.module';

@NgModule({
    imports: [
        EazykarSharedModule,
        Login2Module,
        Register2Module,
        ForgotPassword2Module,
        ResetPassword2Module,
        MailConfirmModule,
        TaxKnowledgeModule,
        EazykarAppTaxServicesModule,
        UserProfileModule,
        ApplicationListModule,
        WorkflowModule
    ],
    declarations: []
})
export class PagesModule {

}
