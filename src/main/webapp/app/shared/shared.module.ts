import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { MatButtonModule, MatIconModule, MatProgressBarModule, MatTooltipModule } from '@angular/material';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';
import { FileUploadComponent } from 'app/shared/file-upload/file-upload.component';
import { EazykarSharedCommonModule, EazykarSharedLibsModule, EzkrLoginModalComponent, HasAnyAuthorityDirective } from './';
import { HasNoneOfTheAuthoritiesDirective } from './auth/has-none-of-the-authorities.directive';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';

@NgModule({
    imports: [
        EazykarSharedLibsModule,
        EazykarSharedCommonModule,
        MatIconModule,
        MatProgressBarModule,
        MatTooltipModule,
        MatButtonModule
    ],
    declarations: [
        EzkrLoginModalComponent,
        HasAnyAuthorityDirective,
        HasNoneOfTheAuthoritiesDirective,
        FileUploadComponent
    ],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [EzkrLoginModalComponent],
    exports: [
        EazykarSharedCommonModule,
        EzkrLoginModalComponent,
        HasAnyAuthorityDirective,
        HasNoneOfTheAuthoritiesDirective,
        FileUploadComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarSharedModule {
    static forRoot() {
        return {
            ngModule: EazykarSharedModule
        };
    }
}
