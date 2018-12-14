import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IUserPlan } from 'app/shared/model/user-plan.model';

type EntityResponseType = HttpResponse<IUserPlan>;
type EntityArrayResponseType = HttpResponse<IUserPlan[]>;

@Injectable({ providedIn: 'root' })
export class UserPlanService {
    public resourceUrl = SERVER_API_URL + 'api/user-plans';

    constructor(private http: HttpClient) {}

    create(userPlan: IUserPlan): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(userPlan);
        return this.http
            .post<IUserPlan>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(userPlan: IUserPlan): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(userPlan);
        return this.http
            .put<IUserPlan>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IUserPlan>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IUserPlan[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(userPlan: IUserPlan): IUserPlan {
        const copy: IUserPlan = Object.assign({}, userPlan, {
            purchasedOn: userPlan.purchasedOn != null && userPlan.purchasedOn.isValid() ? userPlan.purchasedOn.format(DATE_FORMAT) : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.purchasedOn = res.body.purchasedOn != null ? moment(res.body.purchasedOn) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((userPlan: IUserPlan) => {
                userPlan.purchasedOn = userPlan.purchasedOn != null ? moment(userPlan.purchasedOn) : null;
            });
        }
        return res;
    }
}
