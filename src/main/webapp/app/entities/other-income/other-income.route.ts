import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { OtherIncome } from 'app/shared/model/other-income.model';
import { OtherIncomeService } from './other-income.service';
import { OtherIncomeComponent } from './other-income.component';
import { OtherIncomeDetailComponent } from './other-income-detail.component';
import { OtherIncomeUpdateComponent } from './other-income-update.component';
import { OtherIncomeDeletePopupComponent } from './other-income-delete-dialog.component';
import { IOtherIncome } from 'app/shared/model/other-income.model';

@Injectable({ providedIn: 'root' })
export class OtherIncomeResolve implements Resolve<IOtherIncome> {
    constructor(private service: OtherIncomeService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OtherIncome> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<OtherIncome>) => response.ok),
                map((otherIncome: HttpResponse<OtherIncome>) => otherIncome.body)
            );
        }
        return of(new OtherIncome());
    }
}

export const otherIncomeRoute: Routes = [
    {
        path: 'other-income',
        component: OtherIncomeComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'eazykarApp.otherIncome.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'other-income/:id/view',
        component: OtherIncomeDetailComponent,
        resolve: {
            otherIncome: OtherIncomeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.otherIncome.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'other-income/new',
        component: OtherIncomeUpdateComponent,
        resolve: {
            otherIncome: OtherIncomeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.otherIncome.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'other-income/:id/edit',
        component: OtherIncomeUpdateComponent,
        resolve: {
            otherIncome: OtherIncomeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.otherIncome.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const otherIncomePopupRoute: Routes = [
    {
        path: 'other-income/:id/delete',
        component: OtherIncomeDeletePopupComponent,
        resolve: {
            otherIncome: OtherIncomeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.otherIncome.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
