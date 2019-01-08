import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { IDeduction } from 'app/shared/model/deduction.model';
import { Observable } from 'rxjs';
import { createRequestOption } from 'app/shared';

type EntityResponseType = HttpResponse<IDeduction>;
type EntityArrayResponseType = HttpResponse<IDeduction[]>;

@Injectable({ providedIn: 'root' })
export class DeductionService {
    public resourceUrl = SERVER_API_URL + 'api/deductions';

    constructor(private http: HttpClient) {}

    create(deduction: IDeduction): Observable<EntityResponseType> {
        return this.http.post<IDeduction>(this.resourceUrl, deduction, { observe: 'response' });
    }

    update(deduction: IDeduction): Observable<EntityResponseType> {
        return this.http.put<IDeduction>(this.resourceUrl, deduction, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IDeduction>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IDeduction[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
