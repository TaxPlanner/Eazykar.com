import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ItrApplication } from 'app/shared/model/itr-application.model';
import { ItrApplicationService } from './itr-application.service';
import { ItrApplicationComponent } from './itr-application.component';
import { ItrApplicationDetailComponent } from './itr-application-detail.component';
import { ItrApplicationUpdateComponent } from './itr-application-update.component';
import { ItrApplicationDeletePopupComponent } from './itr-application-delete-dialog.component';
import { IItrApplication } from 'app/shared/model/itr-application.model';

@Injectable({ providedIn: 'root' })
export class ItrApplicationResolve implements Resolve<IItrApplication> {
    constructor(private service: ItrApplicationService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ItrApplication> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<ItrApplication>) => response.ok),
                map((itrApplication: HttpResponse<ItrApplication>) => itrApplication.body)
            );
        }
        return of(new ItrApplication());
    }
}

export const itrApplicationRoute: Routes = [
    {
        path: 'itr-application',
        component: ItrApplicationComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'eazykarApp.itrApplication.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'itr-application/:id/view',
        component: ItrApplicationDetailComponent,
        resolve: {
            itrApplication: ItrApplicationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.itrApplication.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'itr-application/new',
        component: ItrApplicationUpdateComponent,
        resolve: {
            itrApplication: ItrApplicationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.itrApplication.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'itr-application/:id/edit',
        component: ItrApplicationUpdateComponent,
        resolve: {
            itrApplication: ItrApplicationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.itrApplication.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const itrApplicationPopupRoute: Routes = [
    {
        path: 'itr-application/:id/delete',
        component: ItrApplicationDeletePopupComponent,
        resolve: {
            itrApplication: ItrApplicationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.itrApplication.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
