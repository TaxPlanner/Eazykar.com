import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal, UserService } from 'app/core';
import { OtherIncomeService } from 'app/main/pages/workflow/information-gathering/other-income/other-income.service';
import { IOtherIncome } from 'app/shared/model/other-income.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-other-income',
    templateUrl: './other-income.component.html'
})
export class OtherIncomeComponent implements OnInit {

    isSaving: boolean;
    existingOtherIncome = false;
    otherIncome: IOtherIncome;
    otherIncomeForm: FormGroup;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private userService: UserService,
                private otherIncomeService: OtherIncomeService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.otherIncomeForm = this._formBuilder.group({
            interestIncome: [''],
            anyOtherIncome: [''],
            exemptDividend: [''],
            exemptInterest: [''],
            exemptOtherIncome: ['']
        });

        this.loadOtherIncome();
    }

    private loadOtherIncome() {

        this.principal.identity().then(account => {
            this.otherIncomeService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IOtherIncome[]>) => this.onOtherIncomeLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onOtherIncomeLoadError(res)
                );
        });
    }

    private onOtherIncomeLoadSuccess(response: HttpResponse<IOtherIncome[]>) {

        this.existingOtherIncome = response && response.body && response.body.length === 1;

        if (this.existingOtherIncome) {
            this.otherIncome = response.body[0];
            this.otherIncomeForm.patchValue({ ...this.otherIncome });
        }
    }

    private onOtherIncomeLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveOtherIncome() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                this.otherIncome = {
                    id: this.otherIncome && this.otherIncome.id,
                    interestIncome: this.otherIncomeForm.controls.interestIncome.value,
                    anyOtherIncome: this.otherIncomeForm.controls.anyOtherIncome.value,
                    exemptDividend: this.otherIncomeForm.controls.exemptDividend.value,
                    exemptInterest: this.otherIncomeForm.controls.exemptInterest.value,
                    exemptOtherIncome: this.otherIncomeForm.controls.exemptOtherIncome.value,
                    user: account
                };

                if (this.existingOtherIncome) {
                    this.subscribeToSaveOtherIncome(this.otherIncomeService.update(this.otherIncome));
                } else {
                    this.subscribeToSaveOtherIncome(this.otherIncomeService.create(this.otherIncome));
                }
            });
    }

    private subscribeToSaveOtherIncome(result: Observable<HttpResponse<IOtherIncome>>) {
        result.subscribe(
            (res: HttpResponse<IOtherIncome>) => this.onSaveOtherIncomeSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveOtherIncomeSuccess(savedOtherIncome: IOtherIncome) {

        this.otherIncome = { ...savedOtherIncome };
        this.isSaving = false;
        this.existingOtherIncome = true;

        this.onSuccess('Your income details were saved.');
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
