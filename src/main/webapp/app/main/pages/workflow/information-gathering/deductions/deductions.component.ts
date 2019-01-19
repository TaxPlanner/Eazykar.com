import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { IUser, UserService } from 'app/core';
import { DeductionService } from 'app/main/pages/workflow/information-gathering/deductions/deduction.service';
import { IDeduction } from 'app/shared/model/deduction.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-deductions',
    templateUrl: './deductions.component.html',
    styles: []
})
export class DeductionsComponent implements OnInit {

    isSaving: boolean;
    existingDeduction = false;
    deduction: IDeduction;
    deductionForm: FormGroup;

    @Input() client: IUser;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private userService: UserService,
                private deductionService: DeductionService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.deductionForm = this._formBuilder.group({
            d80C: [null],
            d80TTA: [null],
            d80G: [null],
            d80DPreventiveHealth: [null],
            d80DInsuranceFamilyPremium: [null],
            d80DFamilyCheckUpFees: [null],
            d80DInsuranceParentsPremium: [null],
            d80DParentsCheckUpFees: [null],
            d80DParentsSeniorCitizens: [false],
            d80E: [null],
            d80CCC: [null],
            d80CCD2: [null],
            otherDeductions: [null]
        });

        this.loadDeduction();
    }

    private loadDeduction() {

        this.deductionService.query({ 'userId.equals': this.client.id })
            .subscribe(
                (response: HttpResponse<IDeduction[]>) => this.onDeductionLoadSuccess(response),
                (res: HttpErrorResponse) => this.onDeductionLoadError(res)
            );
    }

    private onDeductionLoadSuccess(response: HttpResponse<IDeduction[]>) {

        this.existingDeduction = response && response.body && response.body.length > 0;

        if (this.existingDeduction) {
            this.deduction = response.body[0];
            this.deductionForm.patchValue({ ...this.deduction });
        }
    }

    private onDeductionLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    saveDeduction() {
        this.isSaving = true;

        this.deduction = {
            id: this.deduction && this.deduction.id,
            d80C: this.deductionForm.controls.d80C.value,
            d80TTA: this.deductionForm.controls.d80TTA.value,
            d80G: this.deductionForm.controls.d80G.value,
            d80DPreventiveHealth: this.deductionForm.controls.d80DPreventiveHealth.value,
            d80DInsuranceFamilyPremium: this.deductionForm.controls.d80DInsuranceFamilyPremium.value,
            d80DFamilyCheckUpFees: this.deductionForm.controls.d80DFamilyCheckUpFees.value,
            d80DInsuranceParentsPremium: this.deductionForm.controls.d80DInsuranceParentsPremium.value,
            d80DParentsCheckUpFees: this.deductionForm.controls.d80DParentsCheckUpFees.value,
            d80DParentsSeniorCitizens: this.deductionForm.controls.d80DParentsSeniorCitizens.value,
            d80E: this.deductionForm.controls.d80E.value,
            d80CCC: this.deductionForm.controls.d80CCC.value,
            d80CCD2: this.deductionForm.controls.d80CCD2.value,
            otherDeductions: this.deductionForm.controls.otherDeductions.value,
            user: this.client
        };

        if (this.existingDeduction) {
            this.subscribeToSaveDeduction(this.deductionService.update(this.deduction));
        } else {
            this.subscribeToSaveDeduction(this.deductionService.create(this.deduction));
        }

    }

    private subscribeToSaveDeduction(result: Observable<HttpResponse<IDeduction>>) {
        result.subscribe(
            (res: HttpResponse<IDeduction>) => this.onSaveDeductionSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveDeductionSuccess(savedDeduction: IDeduction) {

        this.deduction = { ...savedDeduction };
        this.isSaving = false;
        this.existingDeduction = true;

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
