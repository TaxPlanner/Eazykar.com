import { NgModule } from '@angular/core';
import { HorizontalNavbarModule } from './horizontal-navbar/horizontal-navbar.module';

@NgModule({
    imports: [
        HorizontalNavbarModule
    ],
    exports: [
        HorizontalNavbarModule
    ],
    declarations: []
})
export class LayoutsModule
{
}
