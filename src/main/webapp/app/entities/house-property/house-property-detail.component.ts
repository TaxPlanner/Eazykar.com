import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IHouseProperty } from 'app/shared/model/house-property.model';

@Component({
    selector: 'ezkr-house-property-detail',
    templateUrl: './house-property-detail.component.html'
})
export class HousePropertyDetailComponent implements OnInit {
    houseProperty: IHouseProperty;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ houseProperty }) => {
            this.houseProperty = houseProperty;
        });
    }

    previousState() {
        window.history.back();
    }
}
