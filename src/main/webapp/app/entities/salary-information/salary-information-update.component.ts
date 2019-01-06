import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ISalaryInformation } from 'app/shared/model/salary-information.model';
import { SalaryInformationService } from './salary-information.service';
import { IUser, UserService } from 'app/core';

@Component({
    selector: 'ezkr-salary-information-update',
    templateUrl: './salary-information-update.component.html'
})
export class SalaryInformationUpdateComponent implements OnInit {
    salaryInformation: ISalaryInformation;
    isSaving: boolean;

    users: IUser[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private salaryInformationService: SalaryInformationService,
        private userService: UserService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ salaryInformation }) => {
            this.salaryInformation = salaryInformation;
        });
        this.userService.query().subscribe(
            (res: HttpResponse<IUser[]>) => {
                this.users = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.salaryInformation.id !== undefined) {
            this.subscribeToSaveResponse(this.salaryInformationService.update(this.salaryInformation));
        } else {
            this.subscribeToSaveResponse(this.salaryInformationService.create(this.salaryInformation));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ISalaryInformation>>) {
        result.subscribe((res: HttpResponse<ISalaryInformation>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackUserById(index: number, item: IUser) {
        return item.id;
    }
}
