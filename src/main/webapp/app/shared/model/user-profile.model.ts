import { IUser } from 'app/core/user/user.model';

export interface IUserProfile {
    id?: number;
    middleName?: string;
    fathersName?: string;
    mobileNumber?: string;
    panNumber?: string;
    addressLine1?: string;
    addressLine2?: string;
    addressLine3?: string;
    addressLine4?: string;
    city?: string;
    state?: string;
    pinCode?: string;
    user?: IUser;
}

export class UserProfile implements IUserProfile {
    constructor(
        public id?: number,
        public middleName?: string,
        public fathersName?: string,
        public mobileNumber?: string,
        public panNumber?: string,
        public addressLine1?: string,
        public addressLine2?: string,
        public addressLine3?: string,
        public addressLine4?: string,
        public city?: string,
        public state?: string,
        public pinCode?: string,
        public user?: IUser
    ) {}
}
