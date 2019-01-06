import { IUser } from 'app/core/user/user.model';

export interface IHouseProperty {
    id?: number;
    address?: string;
    tenant?: string;
    propertyTax?: number;
    housingLoanInterest?: number;
    user?: IUser;
}

export class HouseProperty implements IHouseProperty {
    constructor(
        public id?: number,
        public address?: string,
        public tenant?: string,
        public propertyTax?: number,
        public housingLoanInterest?: number,
        public user?: IUser
    ) {}
}
