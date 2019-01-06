import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { SalaryInformation } from 'app/shared/model/salary-information.model';
import { SalaryInformationService } from './salary-information.service';
import { SalaryInformationComponent } from './salary-information.component';
import { SalaryInformationDetailComponent } from './salary-information-detail.component';
import { SalaryInformationUpdateComponent } from './salary-information-update.component';
import { SalaryInformationDeletePopupComponent } from './salary-information-delete-dialog.component';
import { ISalaryInformation } from 'app/shared/model/salary-information.model';

@Injectable({ providedIn: 'root' })
export class SalaryInformationResolve implements Resolve<ISalaryInformation> {
    constructor(private service: SalaryInformationService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<SalaryInformation> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<SalaryInformation>) => response.ok),
                map((salaryInformation: HttpResponse<SalaryInformation>) => salaryInformation.body)
            );
        }
        return of(new SalaryInformation());
    }
}

export const salaryInformationRoute: Routes = [
    {
        path: 'salary-information',
        component: SalaryInformationComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'eazykarApp.salaryInformation.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'salary-information/:id/view',
        component: SalaryInformationDetailComponent,
        resolve: {
            salaryInformation: SalaryInformationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.salaryInformation.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'salary-information/new',
        component: SalaryInformationUpdateComponent,
        resolve: {
            salaryInformation: SalaryInformationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.salaryInformation.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'salary-information/:id/edit',
        component: SalaryInformationUpdateComponent,
        resolve: {
            salaryInformation: SalaryInformationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.salaryInformation.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const salaryInformationPopupRoute: Routes = [
    {
        path: 'salary-information/:id/delete',
        component: SalaryInformationDeletePopupComponent,
        resolve: {
            salaryInformation: SalaryInformationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.salaryInformation.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
