import { NgModule } from '@angular/core';

import { EazykarSharedLibsModule, FindLanguageFromKeyPipe, EzkrAlertComponent, EzkrAlertErrorComponent } from './';

@NgModule({
    imports: [EazykarSharedLibsModule],
    declarations: [FindLanguageFromKeyPipe, EzkrAlertComponent, EzkrAlertErrorComponent],
    exports: [EazykarSharedLibsModule, FindLanguageFromKeyPipe, EzkrAlertComponent, EzkrAlertErrorComponent]
})
export class EazykarSharedCommonModule {}
