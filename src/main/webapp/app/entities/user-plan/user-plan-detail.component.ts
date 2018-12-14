import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IUserPlan } from 'app/shared/model/user-plan.model';

@Component({
    selector: 'ezkr-user-plan-detail',
    templateUrl: './user-plan-detail.component.html'
})
export class UserPlanDetailComponent implements OnInit {
    userPlan: IUserPlan;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ userPlan }) => {
            this.userPlan = userPlan;
        });
    }

    previousState() {
        window.history.back();
    }
}
