import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IDocument } from 'app/shared/model/document.model';
import { Observable } from 'rxjs';

type EntityResponseType = HttpResponse<IDocument>;
type EntityArrayResponseType = HttpResponse<IDocument[]>;

@Injectable({ providedIn: 'root' })
export class DocumentService {
    public resourceUrl = SERVER_API_URL + 'api/documents';

    constructor(private http: HttpClient) {
    }

    create(document: IDocument): Observable<EntityResponseType> {
        return this.http.post<IDocument>(this.resourceUrl, document, { observe: 'response' });
    }

    update(document: IDocument): Observable<EntityResponseType> {
        return this.http.put<IDocument>(this.resourceUrl, document, { observe: 'response' });
    }

    // update2(file: FileUploadModel): Observable<string | HttpResponse<{}>> {
    //
    //     const req = new HttpRequest('POST', this.resourceUrl, file, { reportProgress: true });
    //
    //     return this.http.request(req).pipe(
    //         map(event => {
    //             switch (event.type) {
    //                 case HttpEventType.UploadProgress:
    //                     file.progress = Math.round(event.loaded * 100 / event.total);
    //                     break;
    //                 case HttpEventType.Response:
    //                     return event;
    //             }
    //         }),
    //         tap(message => {
    //         }),
    //         last(),
    //         catchError((error: HttpErrorResponse) => {
    //             file.inProgress = false;
    //             file.canRetry = true;
    //             return of(`${file.data.name} upload failed.`);
    //         })
    //     )/*.subscribe(
    //         (event: any) => {
    //             if (typeof (event) === 'object') {
    //                 this.removeFileFromArray(file);
    //                 this.complete.emit(event.body);
    //             }
    //         }
    //     )*/;
    //
    // }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IDocument>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IDocument[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
