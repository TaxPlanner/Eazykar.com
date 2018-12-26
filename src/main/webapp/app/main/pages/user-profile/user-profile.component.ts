import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material';
import { MomentDateAdapter } from '@angular/material-moment-adapter';

export const MY_FORMATS = {
    parse: {
        dateInput: 'LL'
    },
    display: {
        dateInput: 'LL',
        monthYearLabel: 'MMM YYYY',
        dateA11yLabel: 'LL',
        monthYearA11yLabel: 'MMMM YYYY'
    }
};

@Component({
    selector: 'ezkr-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss'],
    providers: [
        // `MomentDateAdapter` can be automatically provided by importing `MomentDateModule` in your
        // application's root module. We provide it at the component level here, due to limitations of
        // our example generation script.
        { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
        { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS }
    ]
})
export class UserProfileComponent implements OnInit {

    personalInformationForm: FormGroup;
    addressForm: FormGroup;
    keyInformationForm: FormGroup;

    constructor(private _formBuilder: FormBuilder) {
    }

    ngOnInit() {

        this.personalInformationForm = this._formBuilder.group({
            firstName: ['', Validators.required],
            middleName: [''],
            lastName: ['', Validators.required],
            fathersName: [''],
            gender: ['', Validators.required],
            dateOfBirth: ['', Validators.required],
            maritalStatus: ['', Validators.required]
        });

        this.keyInformationForm = this._formBuilder.group({
            panCardNumber: ['', Validators.required],
            aadharCardNumber: [''],
            bankAccountNumber: ['', Validators.required],
            ifscCode: [''],
            bankName: ['', Validators.required],
            bankBranch: ['', Validators.required],
        });

        this.addressForm = this._formBuilder.group({
            line1: ['', Validators.required],
            line2: [''],
            line3: [''],
            line4: [''],
            city: ['', Validators.required],
            state: ['', Validators.required],
            postalCode: ['', Validators.required],
            country: ['India', Validators.required],
        });

    }

}
