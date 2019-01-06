import { IPlan } from 'app/shared/model/plan.model';

export interface PaymentDialogData {
    plan: IPlan;
    email?: string;
    paymentSuccessful: boolean;
}
