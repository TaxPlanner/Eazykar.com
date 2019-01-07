import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal } from 'app/core';
import { KeyInformationService } from 'app/main/pages/user-profile/key-information.service';
import { IKeyInformation } from 'app/shared/model/key-information.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-key-information',
    templateUrl: './key-information.component.html',
    styles: []
})
export class KeyInformationComponent implements OnInit {

    keyInformation: IKeyInformation;
    isSaving: boolean;
    existingKeyInformation = false;

    keyInformationForm: FormGroup;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private keyInformationService: KeyInformationService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.keyInformationForm = this._formBuilder.group({
            panNumber: ['', [Validators.required, Validators.pattern(/^[A-Za-z]{5}\d{4}[A-Za-z]{1}$/)]],
            aadharNumber: [''],
            bankAccountNumber: [''],
            ifscCode: [''],
            bankName: [''],
            bankBranch: ['']
        });

        this.loadKeyInformation();
    }

    private loadKeyInformation() {

        this.principal.identity().then(account => {
            this.keyInformationService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IKeyInformation[]>) => this.onKeyInformationLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onKeyInformationLoadError(res)
                );
        });
    }

    private onKeyInformationLoadSuccess(response: HttpResponse<IKeyInformation[]>) {

        this.existingKeyInformation = response && response.body && response.body.length === 1;

        if (this.existingKeyInformation) {
            this.keyInformation = response.body[0];
            this.keyInformationForm.patchValue({ ...this.keyInformation });
        }
    }

    private onKeyInformationLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveKeyInformation() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                this.keyInformation = {
                    id: this.keyInformation && this.keyInformation.id,
                    panNumber: this.keyInformationForm.controls.panNumber.value,
                    aadharNumber: this.keyInformationForm.controls.aadharNumber.value,
                    bankAccountNumber: this.keyInformationForm.controls.bankAccountNumber.value,
                    ifscCode: this.keyInformationForm.controls.ifscCode.value,
                    bankName: this.keyInformationForm.controls.bankName.value,
                    bankBranch: this.keyInformationForm.controls.bankBranch.value,
                    user: account
                };

                if (this.existingKeyInformation) {
                    this.subscribeToSaveKeyInformation(this.keyInformationService.update(this.keyInformation));
                } else {
                    this.subscribeToSaveKeyInformation(this.keyInformationService.create(this.keyInformation));
                }
            });

    }

    private subscribeToSaveKeyInformation(result: Observable<HttpResponse<IKeyInformation>>) {
        result.subscribe(
            (res: HttpResponse<IKeyInformation>) => this.onSaveKeyInformationSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveKeyInformationSuccess(savedKeyInformation) {
        this.keyInformation = { ...savedKeyInformation };
        this.isSaving = false;
        this.existingKeyInformation = true;

        this.onSuccess('Your key information is now updated in our system');
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
