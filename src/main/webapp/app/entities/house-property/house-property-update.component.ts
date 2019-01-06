import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IHouseProperty } from 'app/shared/model/house-property.model';
import { HousePropertyService } from './house-property.service';
import { IUser, UserService } from 'app/core';

@Component({
    selector: 'ezkr-house-property-update',
    templateUrl: './house-property-update.component.html'
})
export class HousePropertyUpdateComponent implements OnInit {
    houseProperty: IHouseProperty;
    isSaving: boolean;

    users: IUser[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private housePropertyService: HousePropertyService,
        private userService: UserService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ houseProperty }) => {
            this.houseProperty = houseProperty;
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
        if (this.houseProperty.id !== undefined) {
            this.subscribeToSaveResponse(this.housePropertyService.update(this.houseProperty));
        } else {
            this.subscribeToSaveResponse(this.housePropertyService.create(this.houseProperty));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IHouseProperty>>) {
        result.subscribe((res: HttpResponse<IHouseProperty>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
