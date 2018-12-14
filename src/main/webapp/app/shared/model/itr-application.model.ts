import { IUser } from 'app/core/user/user.model';

export const enum ItrApplicationStatus {
    INFORMATION_GATHERING = 'INFORMATION_GATHERING',
    APPLICATION_ASSIGNMENT = 'APPLICATION_ASSIGNMENT',
    ITR_PREPARATION = 'ITR_PREPARATION',
    CLIENT_REVIEW = 'CLIENT_REVIEW',
    CLIENT_APPROVAL = 'CLIENT_APPROVAL',
    ITR_SUBMISSION = 'ITR_SUBMISSION',
    E_VERIFICATION = 'E_VERIFICATION',
    CLIENT_SIGN_OFF = 'CLIENT_SIGN_OFF',
    EAZYKAR_SIGN_OFF = 'EAZYKAR_SIGN_OFF'
}

export interface IItrApplication {
    id?: number;
    applicationNumber?: string;
    assessmentYear?: string;
    applicationStatus?: ItrApplicationStatus;
    user?: IUser;
}

export class ItrApplication implements IItrApplication {
    constructor(
        public id?: number,
        public applicationNumber?: string,
        public assessmentYear?: string,
        public applicationStatus?: ItrApplicationStatus,
        public user?: IUser
    ) {}
}
