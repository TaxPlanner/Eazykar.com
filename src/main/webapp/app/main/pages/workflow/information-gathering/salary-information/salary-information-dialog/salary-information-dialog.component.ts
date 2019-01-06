import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef, MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal, UserService } from 'app/core';
import { SalaryInformationService } from 'app/entities/salary-information';
import { SalaryInformationDialogData } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information-dialog/salary-information-dialog.model';
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
            employerType: [this.data.salaryInformation.employerType, Validators.required],
            income: [this.data.salaryInformation.income, Validators.required],
            employerTan: [this.data.salaryInformation.employerTan, Validators.required],
            tds: [this.data.salaryInformation.tds, Validators.required]
        });
    }

    saveSalaryInformation() {

        this.isSaving = true;
        this.salaryInformation.employerName = this.salaryInformationForm.controls.employerName.value;
        this.salaryInformation.employerType = this.salaryInformationForm.controls.employerType.value;
        this.salaryInformation.income = this.salaryInformationForm.controls.income.value;
        this.salaryInformation.employerTan = this.salaryInformationForm.controls.employerTan.value;
        this.salaryInformation.tds = this.salaryInformationForm.controls.tds.value;

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
