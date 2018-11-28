import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { EazykarSharedLibsModule, EazykarSharedCommonModule, EzkrLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [EazykarSharedLibsModule, EazykarSharedCommonModule],
    declarations: [EzkrLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [EzkrLoginModalComponent],
    exports: [EazykarSharedCommonModule, EzkrLoginModalComponent, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarSharedModule {
    static forRoot() {
        return {
            ngModule: EazykarSharedModule
        };
    }
}
