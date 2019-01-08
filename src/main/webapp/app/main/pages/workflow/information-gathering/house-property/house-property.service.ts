import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { IHouseProperty } from 'app/shared/model/house-property.model';
import { Observable } from 'rxjs';
import { createRequestOption } from 'app/shared';
type EntityResponseType = HttpResponse<IHouseProperty>;
type EntityArrayResponseType = HttpResponse<IHouseProperty[]>;

@Injectable({ providedIn: 'root' })
export class HousePropertyService {
    public resourceUrl = SERVER_API_URL + 'api/house-properties';

    constructor(private http: HttpClient) {}

    create(houseProperty: IHouseProperty): Observable<EntityResponseType> {
        return this.http.post<IHouseProperty>(this.resourceUrl, houseProperty, { observe: 'response' });
    }

    update(houseProperty: IHouseProperty): Observable<EntityResponseType> {
        return this.http.put<IHouseProperty>(this.resourceUrl, houseProperty, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IHouseProperty>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IHouseProperty[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
