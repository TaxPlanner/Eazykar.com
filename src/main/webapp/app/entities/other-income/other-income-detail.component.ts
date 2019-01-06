import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IOtherIncome } from 'app/shared/model/other-income.model';

@Component({
    selector: 'ezkr-other-income-detail',
    templateUrl: './other-income-detail.component.html'
})
export class OtherIncomeDetailComponent implements OnInit {
    otherIncome: IOtherIncome;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ otherIncome }) => {
            this.otherIncome = otherIncome;
        });
    }

    previousState() {
        window.history.back();
    }
}
