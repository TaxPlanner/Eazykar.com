import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';

@Component({
  selector: 'ezkr-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

    /**
     * Constructor
     *
     * @param {MatDialogRef<ArticleComponent>} matDialogRef
     * @param _data
     */
    constructor(
        public matDialogRef: MatDialogRef<ArticleComponent>,
        @Inject(MAT_DIALOG_DATA) public _data: any
    )
    {
    }

  ngOnInit() {
  }

}
