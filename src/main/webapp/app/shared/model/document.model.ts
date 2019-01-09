import { IUser } from 'app/core/user/user.model';

export const enum DocumentType {
    PROFILE_PIC = 'PROFILE_PIC',
    PAN = 'PAN',
    AADHAR = 'AADHAR',
    DEMONETISATION_CASH_DEPOSITS = 'DEMONETISATION_CASH_DEPOSITS',
    BANK_ACCOUNT_DETAILS = 'BANK_ACCOUNT_DETAILS',
    TDS_CERTIFICATES = 'TDS_CERTIFICATES',
    TAX_PAYMENT_CHALLAN = 'TAX_PAYMENT_CHALLAN',
    ORIGINAL_RETURN = 'ORIGINAL_RETURN',
    DETAILS_OF_NOTICE = 'DETAILS_OF_NOTICE',
    ITR_V = 'ITR_V',
    GENERAL_DOCUMENTS = 'GENERAL_DOCUMENTS',
    INCOME_FROM_OTHER_SOURCES = 'INCOME_FROM_OTHER_SOURCES',
    TAX_SAVINGS_INVESTMENTS = 'TAX_SAVINGS_INVESTMENTS',
    OTHER_DEDUCTIONS = 'OTHER_DEDUCTIONS',
    FORM_16 = 'FORM_16',
    SALARY_CERTIFICATE = 'SALARY_CERTIFICATE',
    FORM_26AS = 'FORM_26AS',
    HOUSE_PROPERTY = 'HOUSE_PROPERTY',
    CAPITAL_GAIN = 'CAPITAL_GAIN'
}

export interface IDocument {
    id?: number;
    documentType?: DocumentType;
    documentContentType?: string;
    document?: any;
    documentDescription?: string;
    user?: IUser;
    data?: File;
    state?: string;
    inProgress?: boolean;
}

export class Document implements IDocument {
    constructor(
        public id?: number,
        public documentType?: DocumentType,
        public documentContentType?: string,
        public document?: any,
        public documentDescription?: string,
        public user?: IUser,
        public data?: File,
        public state = 'in',
        public inProgress = false) {}
}
