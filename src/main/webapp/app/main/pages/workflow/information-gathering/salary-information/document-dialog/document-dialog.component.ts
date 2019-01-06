import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';
import { IUser } from 'app/core';
import { DocumentDialogData } from 'app/main/pages/workflow/information-gathering/salary-information/document-dialog/document-dialog.model';

@Component({
    selector: 'ezkr-document-dialog',
    templateUrl: './document-dialog.component.html',
    styleUrls: ['./document-dialog.component.scss']
})
export class DocumentDialogComponent implements OnInit {

    user: IUser;

    constructor(@Inject(MAT_DIALOG_DATA) public data: DocumentDialogData) {
    }

    ngOnInit() {
        this.user = this.data.user;
    }
}
