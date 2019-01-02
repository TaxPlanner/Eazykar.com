import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IItrApplication } from 'app/shared/model/itr-application.model';
import { Observable } from 'rxjs';

type EntityResponseType = HttpResponse<IItrApplication>;
type EntityArrayResponseType = HttpResponse<IItrApplication[]>;

@Injectable({ providedIn: 'root' })
export class ItrApplicationService {
    public resourceUrl = SERVER_API_URL + 'api/itr-applications';

    constructor(private http: HttpClient) {}

    create(itrApplication: IItrApplication): Observable<EntityResponseType> {
        return this.http
            .post<IItrApplication>(this.resourceUrl, itrApplication, { observe: 'response' });
    }

    update(itrApplication: IItrApplication): Observable<EntityResponseType> {
        return this.http
            .put<IItrApplication>(this.resourceUrl, itrApplication, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IItrApplication>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IItrApplication[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
