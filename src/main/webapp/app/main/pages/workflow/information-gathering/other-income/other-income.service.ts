import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { IOtherIncome } from 'app/shared/model/other-income.model';
import { Observable } from 'rxjs';
import { createRequestOption } from 'app/shared';
type EntityResponseType = HttpResponse<IOtherIncome>;
type EntityArrayResponseType = HttpResponse<IOtherIncome[]>;

@Injectable({ providedIn: 'root' })
export class OtherIncomeService {
    public resourceUrl = SERVER_API_URL + 'api/other-incomes';

    constructor(private http: HttpClient) {}

    create(otherIncome: IOtherIncome): Observable<EntityResponseType> {
        return this.http.post<IOtherIncome>(this.resourceUrl, otherIncome, { observe: 'response' });
    }

    update(otherIncome: IOtherIncome): Observable<EntityResponseType> {
        return this.http.put<IOtherIncome>(this.resourceUrl, otherIncome, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IOtherIncome>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IOtherIncome[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
