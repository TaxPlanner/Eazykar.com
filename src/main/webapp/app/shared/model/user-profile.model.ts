import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';

export const enum Gender {
    MALE = 'MALE',
    FEMALE = 'FEMALE'
}

export const enum MaritalStatus {
    BACHELOR = 'BACHELOR',
    MARRIED = 'MARRIED',
    DIVORCED = 'DIVORCED',
    PREFER_NOT_TO_DISCLOSE = 'PREFER_NOT_TO_DISCLOSE'
}

export interface IUserProfile {
    id?: number;
    middleName?: string;
    fathersName?: string;
    secondaryEmail?: string;
    mobileNumber?: string;
    dateOfBirth?: Moment;
    gender?: Gender;
    maritalStatus?: MaritalStatus;
    user?: IUser;
}

export class UserProfile implements IUserProfile {
    constructor(
        public id?: number,
        public middleName?: string,
        public fathersName?: string,
        public secondaryEmail?: string,
        public mobileNumber?: string,
        public dateOfBirth?: Moment,
        public gender?: Gender,
        public maritalStatus?: MaritalStatus,
        public user?: IUser
    ) {}
}
