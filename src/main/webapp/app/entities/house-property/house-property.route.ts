import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { HouseProperty } from 'app/shared/model/house-property.model';
import { HousePropertyService } from './house-property.service';
import { HousePropertyComponent } from './house-property.component';
import { HousePropertyDetailComponent } from './house-property-detail.component';
import { HousePropertyUpdateComponent } from './house-property-update.component';
import { HousePropertyDeletePopupComponent } from './house-property-delete-dialog.component';
import { IHouseProperty } from 'app/shared/model/house-property.model';

@Injectable({ providedIn: 'root' })
export class HousePropertyResolve implements Resolve<IHouseProperty> {
    constructor(private service: HousePropertyService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<HouseProperty> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<HouseProperty>) => response.ok),
                map((houseProperty: HttpResponse<HouseProperty>) => houseProperty.body)
            );
        }
        return of(new HouseProperty());
    }
}

export const housePropertyRoute: Routes = [
    {
        path: 'house-property',
        component: HousePropertyComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'eazykarApp.houseProperty.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'house-property/:id/view',
        component: HousePropertyDetailComponent,
        resolve: {
            houseProperty: HousePropertyResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.houseProperty.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'house-property/new',
        component: HousePropertyUpdateComponent,
        resolve: {
            houseProperty: HousePropertyResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.houseProperty.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'house-property/:id/edit',
        component: HousePropertyUpdateComponent,
        resolve: {
            houseProperty: HousePropertyResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.houseProperty.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const housePropertyPopupRoute: Routes = [
    {
        path: 'house-property/:id/delete',
        component: HousePropertyDeletePopupComponent,
        resolve: {
            houseProperty: HousePropertyResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'eazykarApp.houseProperty.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
