import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatButtonModule, MatIconModule, MatMenuModule, MatTooltipModule } from '@angular/material';

import { FusePipesModule } from '../../../@fuse/pipes/pipes.module';

@NgModule({
    declarations: [
        // FuseMaterialColorPickerComponent
    ],
    imports: [
        CommonModule,

        FlexLayoutModule,

        MatButtonModule,
        MatIconModule,
        MatMenuModule,
        MatTooltipModule,

        FusePipesModule
    ],
    exports: [
        // FuseMaterialColorPickerComponent
    ],
})
export class FuseMaterialColorPickerModule
{
}
