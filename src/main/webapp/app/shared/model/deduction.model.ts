import { IUser } from 'app/core/user/user.model';

export interface IDeduction {
    id?: number;
    d80C?: number;
    d80TTA?: number;
    d80G?: number;
    d80DPreventiveHealth?: number;
    d80DInsuranceFamilyPremium?: number;
    d80DFamilyCheckUpFees?: number;
    d80DInsuranceParentsPremium?: number;
    d80DParentsCheckUpFees?: number;
    d80DParentsSeniorCitizens?: boolean;
    d80E?: number;
    d80CCC?: number;
    d80CCD2?: number;
    otherDeductions?: number;
    user?: IUser;
}

export class Deduction implements IDeduction {
    constructor(
        public id?: number,
        public d80C?: number,
        public d80TTA?: number,
        public d80G?: number,
        public d80DPreventiveHealth?: number,
        public d80DInsuranceFamilyPremium?: number,
        public d80DFamilyCheckUpFees?: number,
        public d80DInsuranceParentsPremium?: number,
        public d80DParentsCheckUpFees?: number,
        public d80DParentsSeniorCitizens?: boolean,
        public d80E?: number,
        public d80CCC?: number,
        public d80CCD2?: number,
        public otherDeductions?: number,
        public user?: IUser
    ) {
        this.d80DParentsSeniorCitizens = this.d80DParentsSeniorCitizens || false;
    }
}
