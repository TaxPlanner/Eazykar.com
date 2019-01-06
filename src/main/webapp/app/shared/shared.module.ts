import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { MatButtonModule, MatIconModule, MatProgressBarModule } from '@angular/material';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';
import { FileUploadComponent } from 'app/shared/file-upload/file-upload.component';
import { EazykarSharedCommonModule, EazykarSharedLibsModule, EzkrLoginModalComponent, HasAnyAuthorityDirective } from './';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';

@NgModule({
    imports: [EazykarSharedLibsModule, EazykarSharedCommonModule, MatIconModule, MatProgressBarModule, MatButtonModule],
    declarations: [EzkrLoginModalComponent, HasAnyAuthorityDirective, FileUploadComponent],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [EzkrLoginModalComponent],
    exports: [EazykarSharedCommonModule, EzkrLoginModalComponent, HasAnyAuthorityDirective, FileUploadComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarSharedModule {
    static forRoot() {
        return {
            ngModule: EazykarSharedModule
        };
    }
}
