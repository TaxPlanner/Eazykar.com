import { IUser } from 'app/core/user/user.model';

export interface IOtherIncome {
    id?: number;
    interestIncome?: number;
    anyOtherIncome?: number;
    exemptDividend?: number;
    exemptInterest?: number;
    exemptOtherIncome?: number;
    user?: IUser;
}

export class OtherIncome implements IOtherIncome {
    constructor(
        public id?: number,
        public interestIncome?: number,
        public anyOtherIncome?: number,
        public exemptDividend?: number,
        public exemptInterest?: number,
        public exemptOtherIncome?: number,
        public user?: IUser
    ) {}
}
