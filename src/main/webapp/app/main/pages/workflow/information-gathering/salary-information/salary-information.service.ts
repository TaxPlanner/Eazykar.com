import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { ISalaryInformation } from 'app/shared/model/salary-information.model';
import { Observable } from 'rxjs';
import { createRequestOption } from 'app/shared';
type EntityResponseType = HttpResponse<ISalaryInformation>;
type EntityArrayResponseType = HttpResponse<ISalaryInformation[]>;

@Injectable({ providedIn: 'root' })
export class SalaryInformationService {
    public resourceUrl = SERVER_API_URL + 'api/salary-informations';

    constructor(private http: HttpClient) {}

    create(salaryInformation: ISalaryInformation): Observable<EntityResponseType> {
        return this.http.post<ISalaryInformation>(this.resourceUrl, salaryInformation, { observe: 'response' });
    }

    update(salaryInformation: ISalaryInformation): Observable<EntityResponseType> {
        return this.http.put<ISalaryInformation>(this.resourceUrl, salaryInformation, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ISalaryInformation>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ISalaryInformation[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
