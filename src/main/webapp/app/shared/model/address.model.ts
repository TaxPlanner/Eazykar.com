import { IUser } from 'app/core/user/user.model';

export interface IAddress {
    id?: number;
    line1?: string;
    line2?: string;
    line3?: string;
    line4?: string;
    city?: string;
    state?: string;
    country?: string;
    postalCode?: string;
    user?: IUser;
}

export class Address implements IAddress {
    constructor(
        public id?: number,
        public line1?: string,
        public line2?: string,
        public line3?: string,
        public line4?: string,
        public city?: string,
        public state?: string,
        public country?: string,
        public postalCode?: string,
        public user?: IUser
    ) {}
}
