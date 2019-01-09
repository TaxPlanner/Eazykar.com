import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { IUser, Principal, UserService } from 'app/core';
import { CapitalGainService } from 'app/main/pages/workflow/information-gathering/capital-gains/capital-gain.service';
import { DocumentService } from 'app/shared/file-upload/document.service';
import { ICapitalGain } from 'app/shared/model/capital-gain.model';
import { IDocument } from 'app/shared/model/document.model';
import * as moment from 'moment';
import { JhiDataUtils } from 'ng-jhipster';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-capital-gains',
    templateUrl: './capital-gains.component.html'
})
export class CapitalGainsComponent implements OnInit {

    isSaving: boolean;
    existingCapitalGain = false;
    capitalGain: ICapitalGain;
    capitalGainForm: FormGroup;

    capitalGainReportDisplayedColumns = [
        'description',
        'actions'
    ];

    user: IUser;
    capitalGainReportList: IDocument[] = [];

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private dataUtils: JhiDataUtils,
                private userService: UserService,
                private documentService: DocumentService,
                private capitalGainService: CapitalGainService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.capitalGainForm = this._formBuilder.group({
            shareType: [null],
            shareDateOfSale: [null],
            shareDateOfPurchase: [null],
            mutualFundType: [null],
            mutualFundDateOfSale: [null],
            mutualFundDateOfPurchase: [null],
            otherThanSharesDateOfSale: [null],
            otherThanSharesDateOfPurchase: [null],
            landBuilding: [null]
        });

        this.loadInformation();
    }

    private loadInformation() {
        this.loadCapitalGainReportList();
        this.loadCapitalGain();
    }

    private loadCapitalGain() {

        this.principal.identity().then(account => {
            this.capitalGainService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<ICapitalGain[]>) => this.onCapitalGainLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onCapitalGainLoadError(res)
                );
        });
    }

    private loadCapitalGainReportList() {
        this.principal.identity().then(account => {
            this.user = account;
            this.documentService.query({
                    'userId.equals': account.id,
                    'documentType.equals': 'CAPITAL_GAIN'
                })
                .subscribe((response: HttpResponse<IDocument[]>) => this.onCapitalGainReportListLoadSuccess(response));
        });
    }

    openCapitalGainReport(selectedCapitalGainReport: IDocument) {
        return this.dataUtils.openFile(selectedCapitalGainReport.documentContentType, selectedCapitalGainReport.document);
    }

    deleteCapitalGainReport(selectedCapitalGainReport: IDocument) {

        this.documentService.delete(selectedCapitalGainReport.id)
            .subscribe(() => this.loadCapitalGainReportList());
    }

    onUploadComplete(event) {
        this.loadCapitalGainReportList();
        this.openSnackBar(event);
    }

    private onCapitalGainLoadSuccess(response: HttpResponse<ICapitalGain[]>) {

        this.existingCapitalGain = response && response.body && response.body.length > 0;

        if (this.existingCapitalGain) {
            this.capitalGain = response.body[0];
            this.capitalGainForm.patchValue({ ...this.capitalGain });
        }
    }

    private onCapitalGainLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveCapitalGain() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                this.capitalGain = {
                    id: this.capitalGain && this.capitalGain.id,
                    shareType: this.capitalGainForm.controls.shareType.value === '' ? null : this.capitalGainForm.controls.shareType.value,
                    shareDateOfSale: moment(this.capitalGainForm.controls.shareDateOfSale.value),
                    shareDateOfPurchase: moment(this.capitalGainForm.controls.shareDateOfPurchase.value),
                    mutualFundType: this.capitalGainForm.controls.mutualFundType.value === '' ? null : this.capitalGainForm.controls.mutualFundType.value,
                    mutualFundDateOfSale: moment(this.capitalGainForm.controls.mutualFundDateOfSale.value),
                    mutualFundDateOfPurchase: moment(this.capitalGainForm.controls.mutualFundDateOfPurchase.value),
                    otherThanSharesDateOfSale: moment(this.capitalGainForm.controls.otherThanSharesDateOfSale.value),
                    otherThanSharesDateOfPurchase: moment(this.capitalGainForm.controls.otherThanSharesDateOfPurchase.value),
                    landBuilding: this.capitalGainForm.controls.landBuilding.value,
                    user: account
                };

                if (this.existingCapitalGain) {
                    this.subscribeToSaveCapitalGain(this.capitalGainService.update(this.capitalGain));
                } else {
                    this.subscribeToSaveCapitalGain(this.capitalGainService.create(this.capitalGain));
                }
            });
    }

    private subscribeToSaveCapitalGain(result: Observable<HttpResponse<ICapitalGain>>) {
        result.subscribe(
            (res: HttpResponse<ICapitalGain>) => this.onSaveCapitalGainSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveCapitalGainSuccess(savedCapitalGain: ICapitalGain) {

        this.capitalGain = { ...savedCapitalGain };
        this.isSaving = false;
        this.existingCapitalGain = true;

        this.onSuccess('Your Capital Gain details were saved.');
    }

    private onSaveError(message) {
        this.isSaving = false;
        this.onError(message);
    }

    private onSuccess(message) {
        this.openSnackBar(message);
    }

    private onError(message) {
        this.openSnackBar(message);
    }

    private onCapitalGainReportListLoadSuccess(response: HttpResponse<IDocument[]>) {
        this.capitalGainReportList = response.body;
    }

    private openSnackBar(message) {
        this.snackBar.open(message, 'Ok', {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }

    sizeInKb(value: string): number {
        return Math.ceil((value.length / 4 * 3 - CapitalGainsComponent.paddingSize(value)) / 1024);
    }

    private static paddingSize(value: string): number {
        if (CapitalGainsComponent.endsWith('==', value)) {
            return 2;
        }
        if (CapitalGainsComponent.endsWith('=', value)) {
            return 1;
        }
        return 0;
    }

    private static endsWith(suffix: string, str: string): boolean {
        return str.indexOf(suffix, str.length - suffix.length) !== -1;
    }

}
