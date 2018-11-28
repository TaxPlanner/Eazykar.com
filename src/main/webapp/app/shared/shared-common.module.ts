import { NgModule } from '@angular/core';

import { EazykarSharedLibsModule, EzkrAlertComponent, EzkrAlertErrorComponent } from './';

@NgModule({
    imports: [EazykarSharedLibsModule],
    declarations: [EzkrAlertComponent, EzkrAlertErrorComponent],
    exports: [EazykarSharedLibsModule, EzkrAlertComponent, EzkrAlertErrorComponent]
})
export class EazykarSharedCommonModule {}
