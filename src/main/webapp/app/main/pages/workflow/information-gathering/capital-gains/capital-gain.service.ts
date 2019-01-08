import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SERVER_API_URL } from 'app/app.constants';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { ICapitalGain } from 'app/shared/model/capital-gain.model';
import * as moment from 'moment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { createRequestOption } from 'app/shared';
type EntityResponseType = HttpResponse<ICapitalGain>;
type EntityArrayResponseType = HttpResponse<ICapitalGain[]>;

@Injectable({ providedIn: 'root' })
export class CapitalGainService {
    public resourceUrl = SERVER_API_URL + 'api/capital-gains';

    constructor(private http: HttpClient) {}

    create(capitalGain: ICapitalGain): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(capitalGain);
        return this.http
            .post<ICapitalGain>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(capitalGain: ICapitalGain): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(capitalGain);
        return this.http
            .put<ICapitalGain>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ICapitalGain>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ICapitalGain[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(capitalGain: ICapitalGain): ICapitalGain {
        const copy: ICapitalGain = Object.assign({}, capitalGain, {
            shareDateOfSale:
                capitalGain.shareDateOfSale != null && capitalGain.shareDateOfSale.isValid()
                    ? capitalGain.shareDateOfSale.format(DATE_FORMAT)
                    : null,
            shareDateOfPurchase:
                capitalGain.shareDateOfPurchase != null && capitalGain.shareDateOfPurchase.isValid()
                    ? capitalGain.shareDateOfPurchase.format(DATE_FORMAT)
                    : null,
            mutualFundDateOfSale:
                capitalGain.mutualFundDateOfSale != null && capitalGain.mutualFundDateOfSale.isValid()
                    ? capitalGain.mutualFundDateOfSale.format(DATE_FORMAT)
                    : null,
            mutualFundDateOfPurchase:
                capitalGain.mutualFundDateOfPurchase != null && capitalGain.mutualFundDateOfPurchase.isValid()
                    ? capitalGain.mutualFundDateOfPurchase.format(DATE_FORMAT)
                    : null,
            otherThanSharesDateOfSale:
                capitalGain.otherThanSharesDateOfSale != null && capitalGain.otherThanSharesDateOfSale.isValid()
                    ? capitalGain.otherThanSharesDateOfSale.format(DATE_FORMAT)
                    : null,
            otherThanSharesDateOfPurchase:
                capitalGain.otherThanSharesDateOfPurchase != null && capitalGain.otherThanSharesDateOfPurchase.isValid()
                    ? capitalGain.otherThanSharesDateOfPurchase.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.shareDateOfSale = res.body.shareDateOfSale != null ? moment(res.body.shareDateOfSale) : null;
            res.body.shareDateOfPurchase = res.body.shareDateOfPurchase != null ? moment(res.body.shareDateOfPurchase) : null;
            res.body.mutualFundDateOfSale = res.body.mutualFundDateOfSale != null ? moment(res.body.mutualFundDateOfSale) : null;
            res.body.mutualFundDateOfPurchase =
                res.body.mutualFundDateOfPurchase != null ? moment(res.body.mutualFundDateOfPurchase) : null;
            res.body.otherThanSharesDateOfSale =
                res.body.otherThanSharesDateOfSale != null ? moment(res.body.otherThanSharesDateOfSale) : null;
            res.body.otherThanSharesDateOfPurchase =
                res.body.otherThanSharesDateOfPurchase != null ? moment(res.body.otherThanSharesDateOfPurchase) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((capitalGain: ICapitalGain) => {
                capitalGain.shareDateOfSale = capitalGain.shareDateOfSale != null ? moment(capitalGain.shareDateOfSale) : null;
                capitalGain.shareDateOfPurchase = capitalGain.shareDateOfPurchase != null ? moment(capitalGain.shareDateOfPurchase) : null;
                capitalGain.mutualFundDateOfSale =
                    capitalGain.mutualFundDateOfSale != null ? moment(capitalGain.mutualFundDateOfSale) : null;
                capitalGain.mutualFundDateOfPurchase =
                    capitalGain.mutualFundDateOfPurchase != null ? moment(capitalGain.mutualFundDateOfPurchase) : null;
                capitalGain.otherThanSharesDateOfSale =
                    capitalGain.otherThanSharesDateOfSale != null ? moment(capitalGain.otherThanSharesDateOfSale) : null;
                capitalGain.otherThanSharesDateOfPurchase =
                    capitalGain.otherThanSharesDateOfPurchase != null ? moment(capitalGain.otherThanSharesDateOfPurchase) : null;
            });
        }
        return res;
    }
}
