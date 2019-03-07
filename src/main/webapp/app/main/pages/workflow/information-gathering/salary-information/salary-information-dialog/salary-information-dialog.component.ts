import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {
    MAT_DIALOG_DATA,
    MatAccordion,
    MatDialogRef,
    MatSnackBar,
    MatSnackBarHorizontalPosition,
    MatSnackBarVerticalPosition
} from '@angular/material';
import { Principal, UserService } from 'app/core';
import { SalaryInformationDialogData } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information-dialog/salary-information-dialog.model';
import { SalaryInformationService } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information.service';
import { ISalaryInformation } from 'app/shared/model/salary-information.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-salary-information-dialog',
    templateUrl: './salary-information-dialog.component.html',
    styleUrls: ['./salary-information-dialog.component.scss']
})
export class SalaryInformationDialogComponent implements OnInit {

    user: { firstName: string, lastName: string };

    salaryInformation: ISalaryInformation;
    isSaving: boolean;
    existingSalaryInformation = false;
    mode: 'add' | 'edit' = 'add';

    salaryInformationForm: FormGroup;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    @ViewChild(MatAccordion) accordion: MatAccordion;

    constructor(public dialogRef: MatDialogRef<SalaryInformationDialogComponent>,
                @Inject(MAT_DIALOG_DATA) public data: SalaryInformationDialogData,
                private _formBuilder: FormBuilder,
                private principal: Principal,
                private userService: UserService,
                private salaryInformationService: SalaryInformationService,
                private snackBar: MatSnackBar) {
    }

    ngOnInit() {
        this.loadSalaryInformation();
    }

    private loadSalaryInformation() {
        this.salaryInformation = this.data.salaryInformation;
        this.salaryInformationForm = this._formBuilder.group({
            employerName: [this.data.salaryInformation.employerName, Validators.required],
            employerAddress: [this.data.salaryInformation.employerAddress],
            basicPay: [this.data.salaryInformation.basicPay],
            hra: [this.data.salaryInformation.hra],
            conveyance: [this.data.salaryInformation.conveyance],
            medical: [this.data.salaryInformation.medical],
            lta: [this.data.salaryInformation.lta],
            others: [this.data.salaryInformation.others],
            perquisites: [this.data.salaryInformation.perquisites],
            leaveEncashment: [this.data.salaryInformation.leaveEncashment],
            gratuity: [this.data.salaryInformation.gratuity],
            arrears: [this.data.salaryInformation.arrears],
            professionalTax: [this.data.salaryInformation.professionalTax],
        });
    }

    saveSalaryInformation() {

        this.isSaving = true;
        this.salaryInformation.employerName = this.salaryInformationForm.controls.employerName.value;
        this.salaryInformation.employerAddress = this.salaryInformationForm.controls.employerAddress.value;
        this.salaryInformation.basicPay = this.salaryInformationForm.controls.basicPay.value;
        this.salaryInformation.hra = this.salaryInformationForm.controls.hra.value;
        this.salaryInformation.conveyance = this.salaryInformationForm.controls.conveyance.value;
        this.salaryInformation.medical = this.salaryInformationForm.controls.medical.value;
        this.salaryInformation.lta = this.salaryInformationForm.controls.lta.value;
        this.salaryInformation.others = this.salaryInformationForm.controls.others.value;
        this.salaryInformation.perquisites = this.salaryInformationForm.controls.perquisites.value;
        this.salaryInformation.leaveEncashment = this.salaryInformationForm.controls.leaveEncashment.value;
        this.salaryInformation.gratuity = this.salaryInformationForm.controls.gratuity.value;
        this.salaryInformation.arrears = this.salaryInformationForm.controls.arrears.value;
        this.salaryInformation.professionalTax = this.salaryInformationForm.controls.professionalTax.value;

        this.principal.identity()
            .then(account => {
                if (!this.salaryInformation.user) {
                    this.salaryInformation.user = { ...account };
                }
                if (this.salaryInformation.id) {
                    this.subscribeToSaveSalaryInformation(this.salaryInformationService.update(this.salaryInformation));
                } else {
                    this.subscribeToSaveSalaryInformation(this.salaryInformationService.create(this.salaryInformation));
                }
            });

    }

    private subscribeToSaveSalaryInformation(result: Observable<HttpResponse<ISalaryInformation>>) {
        result.subscribe(
            (res: HttpResponse<ISalaryInformation>) => this.onSaveSalaryInformationSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    onClose(): void {
        console.log('Closing Salary Information Dialog');
        this.data.salaryInformation = this.salaryInformation;
        this.dialogRef.close(this.data);
    }

    private onSaveSalaryInformationSuccess(savedSalaryInformation) {
        this.salaryInformation = { ...savedSalaryInformation };
        this.isSaving = false;
        this.existingSalaryInformation = true;

        this.onSuccess('Your salary information was successfully added.');
        this.onClose();
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
