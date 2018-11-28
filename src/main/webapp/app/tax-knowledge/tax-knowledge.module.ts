import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EazykarSharedModule } from '../shared';

import { TAX_KNOWLEDGE_ROUTE, TaxKnowledgeComponent } from './';

@NgModule({
    imports: [
      EazykarSharedModule,
      RouterModule.forRoot([ TAX_KNOWLEDGE_ROUTE ], { useHash: true })
    ],
    declarations: [
      TaxKnowledgeComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EazykarAppTaxKnowledgeModule {}
