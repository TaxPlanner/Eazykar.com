import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';

export const enum ShareType {
    LISTED_SECURITIES = 'LISTED_SECURITIES',
    NON_LISTED_SECURITIES = 'NON_LISTED_SECURITIES',
    LISTED_DEBENTURES = 'LISTED_DEBENTURES',
    NON_LISTED_DEBENTURES = 'NON_LISTED_DEBENTURES'
}

export const enum MutualFundType {
    EQUITY = 'EQUITY',
    NON_EQUITY = 'NON_EQUITY'
}

export interface ICapitalGain {
    id?: number;
    shareType?: ShareType;
    shareDateOfSale?: Moment;
    shareDateOfPurchase?: Moment;
    mutualFundType?: MutualFundType;
    mutualFundDateOfSale?: Moment;
    mutualFundDateOfPurchase?: Moment;
    otherThanSharesDateOfSale?: Moment;
    otherThanSharesDateOfPurchase?: Moment;
    landBuilding?: string;
    user?: IUser;
}

export class CapitalGain implements ICapitalGain {
    constructor(
        public id?: number,
        public shareType?: ShareType,
        public shareDateOfSale?: Moment,
        public shareDateOfPurchase?: Moment,
        public mutualFundType?: MutualFundType,
        public mutualFundDateOfSale?: Moment,
        public mutualFundDateOfPurchase?: Moment,
        public otherThanSharesDateOfSale?: Moment,
        public otherThanSharesDateOfPurchase?: Moment,
        public landBuilding?: string,
        public user?: IUser
    ) {}
}
