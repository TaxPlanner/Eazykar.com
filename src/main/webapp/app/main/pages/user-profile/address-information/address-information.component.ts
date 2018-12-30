import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal } from 'app/core';
import { AddressService } from 'app/main/pages/user-profile/address.service';
import { IAddress } from 'app/shared/model/address.model';
import { IUserProfile } from 'app/shared/model/user-profile.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-address-information',
    templateUrl: './address-information.component.html'
})
export class AddressInformationComponent implements OnInit {

    address: IAddress;
    isSaving: boolean;
    existingAddress = false;

    addressForm: FormGroup;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private addressService: AddressService,
                public snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.addressForm = this._formBuilder.group({
            line1: ['', Validators.required],
            line2: [''],
            line3: [''],
            line4: [''],
            city: ['', Validators.required],
            state: ['', Validators.required],
            postalCode: ['', Validators.required],
            country: ['India', Validators.required]
        });

        this.loadAddressInformation();
    }

    private loadAddressInformation() {

        this.principal.identity().then(account => {
            this.addressService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IUserProfile[]>) => this.onAddressLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onAddressLoadError(res)
                );
        });
    }

    private onAddressLoadSuccess(response: HttpResponse<IAddress[]>) {

        this.existingAddress = response && response.body && response.body.length === 1;

        if (this.existingAddress) {
            this.address = response.body[0];
            this.addressForm.patchValue({ ...this.address });
        }
    }

    private onAddressLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveAddressInformation() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                this.address = {
                    id: this.address && this.address.id,
                    line1: this.addressForm.controls.line1.value,
                    line2: this.addressForm.controls.line2.value,
                    line3: this.addressForm.controls.line3.value,
                    line4: this.addressForm.controls.line4.value,
                    city: this.addressForm.controls.city.value,
                    state: this.addressForm.controls.state.value,
                    country: this.addressForm.controls.country.value,
                    postalCode: this.addressForm.controls.postalCode.value,
                    user: account
                };

                if (this.existingAddress) {
                    this.subscribeToSaveAddress(this.addressService.update(this.address));
                } else {
                    this.subscribeToSaveAddress(this.addressService.create(this.address));
                }
            });

    }

    private subscribeToSaveAddress(result: Observable<HttpResponse<IAddress>>) {
        result.subscribe(
            (res: HttpResponse<IAddress>) => this.onSaveAddressSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveAddressSuccess(savedAddress) {
        this.address = { ...savedAddress };
        this.isSaving = false;
        this.existingAddress = true;

        this.onSuccess('Your address is now updated in our system');
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
            announcementMessage: 'Error',
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }
}
