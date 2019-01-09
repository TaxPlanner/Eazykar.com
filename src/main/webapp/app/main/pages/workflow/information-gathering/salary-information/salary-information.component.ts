import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { fuseAnimations } from 'app/@fuse/animations';
import { IUser, Principal } from 'app/core';
import { SalaryInformationDialogComponent } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information-dialog/salary-information-dialog.component';
import { SalaryInformationDialogData } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information-dialog/salary-information-dialog.model';
import { SalaryInformationService } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information.service';
import { DocumentService } from 'app/shared/file-upload/document.service';
import { IDocument } from 'app/shared/model/document.model';
import { ISalaryInformation } from 'app/shared/model/salary-information.model';
import { JhiDataUtils } from 'ng-jhipster';

@Component({
    selector: 'ezkr-salary-information',
    templateUrl: './salary-information.component.html',
    styleUrls: ['./salary-information.component.scss'],
    animations: fuseAnimations
})
export class SalaryInformationComponent implements OnInit {

    salaryInformationDisplayedColumns = [
        'employerName',
        'employerType',
        'income',
        'employerTan',
        'tds',
        'actions'
    ];

    form16DisplayedColumns = [
        'description',
        'actions'
    ];

    user: IUser;

    salaryInformationList: ISalaryInformation[] = [];
    form16List: IDocument[] = [];

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private salaryInformationService: SalaryInformationService,
                private documentService: DocumentService,
                private dataUtils: JhiDataUtils,
                private principal: Principal,
                private dialog: MatDialog,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {
        this.loadLists();
    }

    loadLists() {
        this.loadSalaryInformationList();
        this.loadForm16List();
    }

    openSalaryInformationModal(selectedSalaryInformation: ISalaryInformation) {

        const salaryInformationDialogData: SalaryInformationDialogData = {
            salaryInformation: selectedSalaryInformation
        };

        this.dialog.open(SalaryInformationDialogComponent, { data: salaryInformationDialogData })
            .afterClosed()
            .subscribe(() => this.loadSalaryInformationList());
    }

    deleteSalaryInformation(selectedSalaryInformation: ISalaryInformation) {

        this.salaryInformationService.delete(selectedSalaryInformation.id)
            .subscribe(() => this.loadSalaryInformationList());
    }

    openForm16(selectedForm16: IDocument) {
        return this.dataUtils.openFile(selectedForm16.documentContentType, selectedForm16.document);
    }

    deleteForm16(selectedForm16: IDocument) {

        this.documentService.delete(selectedForm16.id)
            .subscribe(() => this.loadForm16List());
    }

    onUploadComplete(event) {
        this.loadForm16List();
        this.openSnackBar(event);
    }

    sizeInKb(value: string): number {
        return Math.ceil((value.length / 4 * 3 - SalaryInformationComponent.paddingSize(value)) / 1024);
    }

    private static paddingSize(value: string): number {
        if (SalaryInformationComponent.endsWith('==', value)) {
            return 2;
        }
        if (SalaryInformationComponent.endsWith('=', value)) {
            return 1;
        }
        return 0;
    }

    private static endsWith(suffix: string, str: string): boolean {
        return str.indexOf(suffix, str.length - suffix.length) !== -1;
    }

    private loadSalaryInformationList() {
        this.principal.identity().then(account => {
            this.salaryInformationService.query({ 'userId.equals': account.id })
                .subscribe((response: HttpResponse<ISalaryInformation[]>) => this.onSalaryInformationListLoadSuccess(response));
        });
    }

    private loadForm16List() {
        this.principal.identity().then(account => {
            this.user = account;
            this.documentService.query({
                    'userId.equals': account.id,
                    'documentType.equals': 'FORM_16'
                })
                .subscribe((response: HttpResponse<IDocument[]>) => this.onForm16ListLoadSuccess(response));
        });
    }

    private onSalaryInformationListLoadSuccess(response: HttpResponse<ISalaryInformation[]>) {
        this.salaryInformationList = response.body;
    }

    private onForm16ListLoadSuccess(response: HttpResponse<IDocument[]>) {
        this.form16List = response.body;
    }

    private openSnackBar(message) {
        this.snackBar.open(message, 'Ok', {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }
}
