import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IItrApplication } from 'app/shared/model/itr-application.model';
import { ItrApplicationService } from './itr-application.service';
import { IUser, UserService } from 'app/core';

@Component({
    selector: 'ezkr-itr-application-update',
    templateUrl: './itr-application-update.component.html'
})
export class ItrApplicationUpdateComponent implements OnInit {
    itrApplication: IItrApplication;
    isSaving: boolean;

    users: IUser[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private itrApplicationService: ItrApplicationService,
        private userService: UserService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ itrApplication }) => {
            this.itrApplication = itrApplication;
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
        if (this.itrApplication.id !== undefined) {
            this.subscribeToSaveResponse(this.itrApplicationService.update(this.itrApplication));
        } else {
            this.subscribeToSaveResponse(this.itrApplicationService.create(this.itrApplication));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IItrApplication>>) {
        result.subscribe((res: HttpResponse<IItrApplication>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
