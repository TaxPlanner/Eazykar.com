import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IOtherIncome } from 'app/shared/model/other-income.model';
import { OtherIncomeService } from './other-income.service';
import { IUser, UserService } from 'app/core';

@Component({
    selector: 'ezkr-other-income-update',
    templateUrl: './other-income-update.component.html'
})
export class OtherIncomeUpdateComponent implements OnInit {
    otherIncome: IOtherIncome;
    isSaving: boolean;

    users: IUser[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private otherIncomeService: OtherIncomeService,
        private userService: UserService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ otherIncome }) => {
            this.otherIncome = otherIncome;
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
        if (this.otherIncome.id !== undefined) {
            this.subscribeToSaveResponse(this.otherIncomeService.update(this.otherIncome));
        } else {
            this.subscribeToSaveResponse(this.otherIncomeService.create(this.otherIncome));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IOtherIncome>>) {
        result.subscribe((res: HttpResponse<IOtherIncome>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
