import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal, UserService } from 'app/core';
import { HousePropertyService } from 'app/main/pages/workflow/information-gathering/house-property/house-property.service';
import { IHouseProperty } from 'app/shared/model/house-property.model';
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

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private userService: UserService,
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

    private openSnackBar(message) {
        this.snackBar.open(message, 'Ok', {
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }
}
