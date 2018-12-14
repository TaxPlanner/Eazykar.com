export const enum PlanType {
    INDIVIDUAL = 'INDIVIDUAL',
    BUSINESS = 'BUSINESS'
}

export interface IPlan {
    id?: number;
    planNumber?: string;
    planName?: string;
    planType?: PlanType;
    planFees?: number;
    active?: boolean;
}

export class Plan implements IPlan {
    constructor(
        public id?: number,
        public planNumber?: string,
        public planName?: string,
        public planType?: PlanType,
        public planFees?: number,
        public active?: boolean
    ) {
        this.active = this.active || false;
    }
}
