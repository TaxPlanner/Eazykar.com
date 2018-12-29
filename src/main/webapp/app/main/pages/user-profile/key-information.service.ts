import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IKeyInformation } from 'app/shared/model/key-information.model';

type EntityResponseType = HttpResponse<IKeyInformation>;
type EntityArrayResponseType = HttpResponse<IKeyInformation[]>;

@Injectable({ providedIn: 'root' })
export class KeyInformationService {
    public resourceUrl = SERVER_API_URL + 'api/key-informations';

    constructor(private http: HttpClient) {}

    create(keyInformation: IKeyInformation): Observable<EntityResponseType> {
        return this.http.post<IKeyInformation>(this.resourceUrl, keyInformation, { observe: 'response' });
    }

    update(keyInformation: IKeyInformation): Observable<EntityResponseType> {
        return this.http.put<IKeyInformation>(this.resourceUrl, keyInformation, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IKeyInformation>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IKeyInformation[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
