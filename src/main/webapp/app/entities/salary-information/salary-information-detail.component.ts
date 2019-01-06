import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISalaryInformation } from 'app/shared/model/salary-information.model';

@Component({
    selector: 'ezkr-salary-information-detail',
    templateUrl: './salary-information-detail.component.html'
})
export class SalaryInformationDetailComponent implements OnInit {
    salaryInformation: ISalaryInformation;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ salaryInformation }) => {
            this.salaryInformation = salaryInformation;
        });
    }

    previousState() {
        window.history.back();
    }
}
