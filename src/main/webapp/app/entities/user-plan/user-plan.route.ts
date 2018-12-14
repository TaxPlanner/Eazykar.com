import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { UserPlan } from 'app/shared/model/user-plan.model';
import { UserPlanService } from './user-plan.service';
import { UserPlanComponent } from './user-plan.component';
import { UserPlanDetailComponent } from './user-plan-detail.component';
import { UserPlanUpdateComponent } from './user-plan-update.component';
import { UserPlanDeletePopupComponent } from './user-plan-delete-dialog.component';
import { IUserPlan } from 'app/shared/model/user-plan.model';

@Injectable({ providedIn: 'root' })
export class UserPlanResolve implements Resolve<IUserPlan> {
    constructor(private service: UserPlanService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<UserPlan> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<UserPlan>) => response.ok),
                map((userPlan: HttpResponse<UserPlan>) => userPlan.body)
            );
        }
        return of(new UserPlan());
    }
}

export const userPlanRoute: Routes = [
    {
        path: 'user-plan',
        component: UserPlanComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'eazykarApp.userPlan.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'user-plan/:id/view',
        component: UserPlanDetailComponent,
        resolve: {
            userPlan: UserPlanResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.userPlan.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'user-plan/new',
        component: UserPlanUpdateComponent,
        resolve: {
            userPlan: UserPlanResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.userPlan.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'user-plan/:id/edit',
        component: UserPlanUpdateComponent,
        resolve: {
            userPlan: UserPlanResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.userPlan.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const userPlanPopupRoute: Routes = [
    {
        path: 'user-plan/:id/delete',
        component: UserPlanDeletePopupComponent,
        resolve: {
            userPlan: UserPlanResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.userPlan.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
