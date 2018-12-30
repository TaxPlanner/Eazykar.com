import { IUser } from 'app/core/user/user.model';
import { IPlan } from 'app/shared/model/plan.model';
import { Moment } from 'moment';

export interface IUserPlan {
    id?: number;
    purchasedOn?: Moment;
    user?: IUser;
    plan?: IPlan;
}

export class UserPlan implements IUserPlan {
    constructor(public id?: number, public purchasedOn?: Moment, public user?: IUser, public plan?: IPlan) {
    }
}
