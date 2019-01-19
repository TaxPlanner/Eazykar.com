import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog, MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material';
import { Principal } from 'app/core';
import { PaymentDialogComponent } from 'app/main/pages/pricing/style-1/payment-dialog/payment-dialog.component';
import { PaymentDialogData } from 'app/main/pages/pricing/style-1/payment-dialog/payment-dialog.model';
import { PlanService } from 'app/main/pages/pricing/style-1/plan.service';
import { UserPlanService } from 'app/main/pages/pricing/style-1/user-plan.service';
import { IPlan, PlanType } from 'app/shared/model/plan.model';
import { IUserPlan } from 'app/shared/model/user-plan.model';
import * as moment from 'moment';

@Component({
    selector: 'pricing-style-1',
    templateUrl: './style-1.component.html',
    styleUrls: ['./style-1.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class PricingStyle1Component implements OnInit {

    account;

    plans: IPlan[];
    individualPlans: IPlan[];
    businessPlans: IPlan[];
    selectedPlan: IPlan;
    userPlan: IUserPlan;
    existingUserPlan = false;

    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private _formBuilder: FormBuilder,
                private principal: Principal,
                private planService: PlanService,
                private userPlanService: UserPlanService,
                private dialog: MatDialog,
                private snackBar: MatSnackBar) {
    }

    ngOnInit(): void {
        this.loadPlanInformation();
        this.principal.identity().then(account => {
            this.account = account;
        });
        if (this.isAuthenticated()) {
            this.loadUserPlanInformation();
        }
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    openPaymentModal(selectedPlan: IPlan) {

        const paymentDialogData: PaymentDialogData = {
            plan: selectedPlan,
            email: this.account.email,
            paymentSuccessful: false
        };

        const dialogRef = this.dialog.open(PaymentDialogComponent, { data: paymentDialogData })
                              .afterClosed()
                              .subscribe(result => {

                                  if (result && result.paymentSuccessful === true) {
                                      this.userPlanService.create({
                                              plan: result.plan,
                                              purchasedOn: moment(),
                                              user: { ...this.account }
                                          })
                                          .subscribe(() => {
                                              this.existingUserPlan = true;
                                              this.selectedPlan = result.plan;
                                              this.onSuccess(`Your payment of ${result.plan.planFees} was successful`);
                                          });
                                  }
                              });
    }

    private loadPlanInformation() {

        this.planService.query({ 'active.equals': true })
            .subscribe(
                (response: HttpResponse<IPlan[]>) => this.onPlansLoadSuccess(response),
                (res: HttpErrorResponse) => this.onPlansLoadError(res)
            );
    }

    private loadUserPlanInformation() {

        this.principal.identity().then(account => {
            this.userPlanService.query({ 'userId.equals': account.id })
                .subscribe(
                    (response: HttpResponse<IUserPlan[]>) => this.onUserPlanLoadSuccess(response),
                    (res: HttpErrorResponse) => this.onUserPlanLoadError(res)
                );
        });
    }

    private onPlansLoadSuccess(response: HttpResponse<IPlan[]>) {
        this.plans = response && response.body;
        this.individualPlans = this.plans.filter(value => value.planType === PlanType.INDIVIDUAL);
        this.businessPlans = this.plans.filter(value => value.planType === PlanType.BUSINESS);
    }

    private onPlansLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    private onUserPlanLoadSuccess(response: HttpResponse<IUserPlan[]>) {

        this.existingUserPlan = response && response.body && response.body.length === 1;

        if (this.existingUserPlan) {
            this.selectedPlan = response.body[0].plan;
        }
    }

    private onUserPlanLoadError(res: HttpErrorResponse) {
        this.onError(res.message);
    }

    private onSuccess(message) {
        this.openSnackBar(message);
    }

    private onError(message) {
        this.openSnackBar(message);
    }

    private openSnackBar(message) {
        this.snackBar.open(message, 'Ok', {
            announcementMessage: 'Error',
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition
        });
    }

}
