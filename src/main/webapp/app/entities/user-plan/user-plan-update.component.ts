import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';

import { IUserPlan } from 'app/shared/model/user-plan.model';
import { UserPlanService } from './user-plan.service';
import { IUser, UserService } from 'app/core';
import { IPlan } from 'app/shared/model/plan.model';
import { PlanService } from 'app/entities/plan';

@Component({
    selector: 'ezkr-user-plan-update',
    templateUrl: './user-plan-update.component.html'
})
export class UserPlanUpdateComponent implements OnInit {
    userPlan: IUserPlan;
    isSaving: boolean;

    users: IUser[];

    plans: IPlan[];
    purchasedOnDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private userPlanService: UserPlanService,
        private userService: UserService,
        private planService: PlanService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ userPlan }) => {
            this.userPlan = userPlan;
        });
        this.userService.query().subscribe(
            (res: HttpResponse<IUser[]>) => {
                this.users = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.planService.query().subscribe(
            (res: HttpResponse<IPlan[]>) => {
                this.plans = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.userPlan.id !== undefined) {
            this.subscribeToSaveResponse(this.userPlanService.update(this.userPlan));
        } else {
            this.subscribeToSaveResponse(this.userPlanService.create(this.userPlan));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IUserPlan>>) {
        result.subscribe((res: HttpResponse<IUserPlan>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackPlanById(index: number, item: IPlan) {
        return item.id;
    }
}
