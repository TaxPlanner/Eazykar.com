import { IUser } from 'app/core/user/user.model';

export interface IKeyInformation {
    id?: number;
    panNumber?: string;
    aadharNumber?: string;
    bankAccountNumber?: string;
    ifscCode?: string;
    bankName?: string;
    bankBranch?: string;
    user?: IUser;
}

export class KeyInformation implements IKeyInformation {
    constructor(
        public id?: number,
        public panNumber?: string,
        public aadharNumber?: string,
        public bankAccountNumber?: string,
        public ifscCode?: string,
        public bankName?: string,
        public bankBranch?: string,
        public user?: IUser
    ) {}
}
