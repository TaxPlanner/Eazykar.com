import { IUser } from 'app/core/user/user.model';

export const enum EmployerType {
    PUBLIC = 'PUBLIC',
    PRIVATE = 'PRIVATE'
}

export interface ISalaryInformation {
    id?: number;
    employerName?: string;
    employerType?: EmployerType;
    employerTan?: string;
    income?: number;
    tds?: number;
    user?: IUser;
}

export class SalaryInformation implements ISalaryInformation {
    constructor(
        public id?: number,
        public employerName?: string,
        public employerType?: EmployerType,
        public employerTan?: string,
        public income?: number,
        public tds?: number,
        public user?: IUser
    ) {}
}
