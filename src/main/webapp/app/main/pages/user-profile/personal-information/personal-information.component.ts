import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { IUser, Principal, UserService } from 'app/core';
import { UserProfileService } from 'app/main/pages/user-profile/user-profile.service';
import { IUserProfile } from 'app/shared/model/user-profile.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-personal-information',
    templateUrl: './personal-information.component.html'
})
export class PersonalInformationComponent implements OnInit {

    user: { firstName: string, lastName: string };
    userProfile: IUserProfile;
    isSaving: boolean;
    existingUserProfile = false;

    personalInformationForm: FormGroup;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private userService: UserService,
                private userProfileService: UserProfileService,
                public snackBar: MatSnackBar) {
    }

    ngOnInit() {

        this.personalInformationForm = this._formBuilder.group({
            firstName: ['', Validators.required],
            middleName: [''],
            lastName: ['', Validators.required],
            fathersName: [''],
            gender: ['', Validators.required],
            dateOfBirth: ['', Validators.required],
            maritalStatus: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            secondaryEmail: ['', [Validators.email]],
            mobileNumber: ['', Validators.required]
        });

        this.loadPersonalInformation();
    }

    private loadPersonalInformation() {

        this.principal.identity().then(account => {

            this.personalInformationForm.patchValue({
                firstName: account.firstName,
                lastName: account.lastName,
                email: account.email
            });

            this.userProfileService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IUserProfile[]>) => this.onPersonalInformationLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onPersonalInformationLoadError(res)
                );
        });
    }

    private onPersonalInformationLoadSuccess(response: HttpResponse<IUserProfile[]>) {

        this.existingUserProfile = response && response.body && response.body.length === 1;

        if (this.existingUserProfile) {
            this.userProfile = response.body[0];
            this.personalInformationForm.patchValue({ ...this.userProfile });
        }
    }

    private onPersonalInformationLoadError(res: HttpErrorResponse) {
        this.existingUserProfile = false;
        this.onError(res.message);
    }

    savePersonalInformation() {

        this.isSaving = true;

        this.principal.identity()
            .then(account => {

                const updatedUser = {
                    ...account,
                    firstName: this.personalInformationForm.controls.firstName.value,
                    lastName: this.personalInformationForm.controls.lastName.value,
                    email: this.personalInformationForm.controls.email.value
                };
                this.userService.update(updatedUser)
                    .subscribe(
                        (response: HttpResponse<IUser>) => {
                            this.userProfile = {
                                id: this.userProfile && this.userProfile.id,
                                middleName: this.personalInformationForm.controls.middleName.value,
                                fathersName: this.personalInformationForm.controls.fathersName.value,
                                dateOfBirth: this.personalInformationForm.controls.dateOfBirth.value,
                                gender: this.personalInformationForm.controls.gender.value,
                                maritalStatus: this.personalInformationForm.controls.maritalStatus.value,
                                mobileNumber: this.personalInformationForm.controls.mobileNumber.value,
                                secondaryEmail: this.personalInformationForm.controls.secondaryEmail.value,
                                user: response.body
                            };

                            if (this.existingUserProfile) {
                                this.subscribeToSaveUserProfile(this.userProfileService.update(this.userProfile));
                            } else {
                                this.subscribeToSaveUserProfile(this.userProfileService.create(this.userProfile));
                            }
                        },
                        (res: HttpErrorResponse) => this.onSaveError(res.message)
                    );
            });

    }

    private subscribeToSaveUserProfile(result: Observable<HttpResponse<IUserProfile>>) {
        result.subscribe(
            (res: HttpResponse<IUserProfile>) => this.onSaveUserProfileSuccess(res.body),
            (res: HttpErrorResponse) => this.onSaveError(res.message)
        );
    }

    private onSaveUserProfileSuccess(savedUserProfile) {
        this.userProfile = { ...savedUserProfile };
        this.isSaving = false;
        this.existingUserProfile = true;

        this.onSuccess('Your personal information is now updated in our system');
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
