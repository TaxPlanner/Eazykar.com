import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatButtonModule, MatDialogModule, MatIconModule, MatListModule, MatToolbarModule } from '@angular/material';
import { FuseSharedModule } from 'app/@fuse/shared.module';
import { TaxKnowledgeComponent } from 'app/main/pages/tax-knowledge/tax-knowledge.component';
import { ArticleComponent } from './dialogs/article/article.component';

const routes = [
    {
        path: 'tax-knowledge',
        component: TaxKnowledgeComponent
    }
];

@NgModule({
    declarations: [
        TaxKnowledgeComponent,
        ArticleComponent
    ],
    imports: [
        RouterModule.forChild(routes),

        MatButtonModule,
        MatDialogModule,
        MatIconModule,
        MatListModule,
        MatToolbarModule,

        FuseSharedModule
    ],
    entryComponents: [
        ArticleComponent
    ]
})
export class TaxKnowledgeModule {
}
