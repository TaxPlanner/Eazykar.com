import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { IUser, Principal, UserService } from 'app/core';
import { HousePropertyService } from 'app/main/pages/workflow/information-gathering/house-property/house-property.service';
import { DocumentService } from 'app/shared/file-upload/document.service';
import { IDocument } from 'app/shared/model/document.model';
import { IHouseProperty } from 'app/shared/model/house-property.model';
import { JhiDataUtils } from 'ng-jhipster';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-house-property',
    templateUrl: './house-property.component.html',
    styles: []
})
export class HousePropertyComponent implements OnInit {

    isSaving: boolean;
    existingHouseProperty = false;
    houseProperty: IHouseProperty;
    housePropertyForm: FormGroup;

    rentReceiptDisplayedColumns = [
        'description',
        'actions'
    ];

    user: IUser;
    rentReceiptList: IDocument[] = [];

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private dataUtils: JhiDataUtils,
                private userService: UserService,
                private documentService: DocumentService,
                private housePropertyService: HousePropertyService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.housePropertyForm = this._formBuilder.group({
            address: [''],
            tenant: [''],
            propertyTax: [''],
            housingLoanInterest: ['']
        });

        this.loadInformation();
    }

    private loadInformation() {
        this.loadRentReceiptList();
        this.loadHouseProperty();
    }

    private loadHouseProperty() {

        this.principal.identity().then(account => {
            this.housePropertyService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IHouseProperty[]>) => this.onHousePropertyLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onHousePropertyLoadError(res)
                );
        });
    }

    private loadRentReceiptList() {
        this.principal.identity().then(account => {
            this.user = account;
            this.documentService.query({
                    'userId.equals': account.id,
                    'documentType.equals': 'HOUSE_PROPERTY'
                })
                .subscribe((response: HttpResponse<IDocument[]>) => this.onRentReceiptListLoadSuccess(response));
        });
    }

    openRentReceipt(selectedRentReceipt: IDocument) {
        return this.dataUtils.openFile(selectedRentReceipt.documentContentType, selectedRentReceipt.document);
    }

    deleteRentReceipt(selectedRentReceipt: IDocument) {

        this.documentService.delete(selectedRentReceipt.id)
            .subscribe(() => this.loadRentReceiptList());
    }

    onUploadComplete(event) {
        this.loadRentReceiptList();
        this.openSnackBar(event);
    }

    private onHousePropertyLoadSuccess(response: HttpResponse<IHouseProperty[]>) {

        this.existingHouseProperty = response && response.body && response.body.length > 0;

        if (this.existingHouseProperty) {
            this.houseProperty = response.body[0];
            this.housePropertyForm.patchValue({ ...this.houseProperty });
        }
    }

    private onHousePropertyLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveHouseProperty() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                this.houseProperty = {
                    id: this.houseProperty && this.houseProperty.id,
                    address: this.housePropertyForm.controls.address.value,
                    tenant: this.housePropertyForm.controls.tenant.value,
                    propertyTax: this.housePropertyForm.controls.propertyTax.value,
                    housingLoanInterest: this.housePropertyForm.controls.housingLoanInterest.value,
                    user: account
                };

                if (this.existingHouseProperty) {
                    this.subscribeToSaveHouseProperty(this.housePropertyService.update(this.houseProperty));
                } else {
                    this.subscribeToSaveHouseProperty(this.housePropertyService.create(this.houseProperty));
                }
            });
    }

    private subscribeToSaveHouseProperty(result: Observable<HttpResponse<IHouseProperty>>) {
        result.subscribe(
            (res: HttpResponse<IHouseProperty>) => this.onSaveHousePropertySuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveHousePropertySuccess(savedHouseProperty: IHouseProperty) {

        this.houseProperty = { ...savedHouseProperty };
        this.isSaving = false;
        this.existingHouseProperty = true;

        this.onSuccess('Your house property details were saved.');
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

    private onRentReceiptListLoadSuccess(response: HttpResponse<IDocument[]>) {
        this.rentReceiptList = response.body;
    }

    private openSnackBar(message) {
        this.snackBar.open(message, 'Ok', {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }

    sizeInKb(value: string): number {
        return Math.ceil((value.length / 4 * 3 - HousePropertyComponent.paddingSize(value)) / 1024);
    }

    private static paddingSize(value: string): number {
        if (HousePropertyComponent.endsWith('==', value)) {
            return 2;
        }
        if (HousePropertyComponent.endsWith('=', value)) {
            return 1;
        }
        return 0;
    }

    private static endsWith(suffix: string, str: string): boolean {
        return str.indexOf(suffix, str.length - suffix.length) !== -1;
    }

}
