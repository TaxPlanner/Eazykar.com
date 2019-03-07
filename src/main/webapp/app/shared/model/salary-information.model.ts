import { IUser } from 'app/core/user/user.model';

export interface ISalaryInformation {
    id?: number;
    employerName?: string;
    employerAddress?: string;
    basicPay?: number;
    hra?: number;
    conveyance?: number;
    medical?: number;
    lta?: number;
    others?: number;
    perquisites?: number;
    leaveEncashment?: number;
    gratuity?: number;
    arrears?: number;
    professionalTax?: number;
    user?: IUser;
}

export class SalaryInformation implements ISalaryInformation {
    constructor(
        public id?: number,
        public employerName?: string,
        public employerAddress?: string,
        public basicPay?: number,
        public hra?: number,
        public conveyance?: number,
        public medical?: number,
        public lta?: number,
        public others?: number,
        public perquisites?: number,
        public leaveEncashment?: number,
        public gratuity?: number,
        public arrears?: number,
        public professionalTax?: number,
        public user?: IUser
    ) {}
}
