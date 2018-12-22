import { Component, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Subject } from 'rxjs';
import { ArticleComponent } from 'app/main/pages/tax-knowledge/dialogs/article/article.component';

@Component({
    selector: 'ezkr-tax-knowledge',
    templateUrl: './tax-knowledge.component.html',
    styleUrls: ['./tax-knowledge.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class TaxKnowledgeComponent implements OnInit, OnDestroy {

    // Private
    private _unsubscribeAll: Subject<any>;

    articles = [
        {
            imageSource: '/content/images/service/1.png',
            title: 'Accounting and Auditing',
            content: `You need to be extremely careful while implementing an internal Accounting or Auditing system.<br>
                      Based on the scale and volume of your business, you are required to follow certain norms and standards.<br>
                      You can talk to our Executives to know more about it and we would assist you to implement the same.`
        },
        {
            imageSource: '/content/images/service/2.png',
            title: 'What are Tax Breaks ?',
            content: `The Financial Acts and Policies is the message from the Government about its long-term goals and vision.<br>
                      To further this vision, the Government encourages the citizens to head in a specific direction and our Team of Experts
                      would be glad to lead you down that track.<br>
                      For instance, Tax breaks on certain infrastructure bonds to develop a particular region. We can also provide a
                      thorough guidance on STPI and SEZ benefits and Tax breaks<br>`
        },
        {
            imageSource: '/content/images/service/taxbreak.jpg',
            title: 'Types of Tax Breaks',
            content: `The Financial Acts and Policies is the message from the Government about its long-term goals and vision.<br>
                      To further this vision, the Government encourages the citizens to head in a specific direction and our Team of Experts
                      would be glad to lead you down that track.<br>
                      For instance, Tax breaks on certain infrastructure bonds to develop a particular region. We can also provide a
                      thorough guidance on STPI and SEZ benefits and Tax breaks<br>`
        }
    ];

    /**
     * Constructor
     *
     * @param {MatDialog} _matDialog
     */
    constructor(
        private _matDialog: MatDialog
    ) {
        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Read article
     *
     * @param article
     */
    readArticle(article): void {
        this._matDialog.open(ArticleComponent, {
            panelClass: 'knowledgebase-article-dialog',
            data: { article }
        });
    }

}
