import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IItrApplication } from 'app/shared/model/itr-application.model';

@Component({
    selector: 'ezkr-itr-application-detail',
    templateUrl: './itr-application-detail.component.html'
})
export class ItrApplicationDetailComponent implements OnInit {
    itrApplication: IItrApplication;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ itrApplication }) => {
            this.itrApplication = itrApplication;
        });
    }

    previousState() {
        window.history.back();
    }
}
