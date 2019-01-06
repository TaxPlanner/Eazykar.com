import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { PaymentDialogData } from 'app/main/pages/pricing/style-1/payment-dialog/payment-dialog.model';

@Component({
    selector: 'ezkr-payment-dialog',
    templateUrl: './payment-dialog.component.html',
    styleUrls: ['./payment-dialog.component.scss']
})
export class PaymentDialogComponent implements OnInit {

    constructor(
        public dialogRef: MatDialogRef<PaymentDialogComponent>,
        @Inject(MAT_DIALOG_DATA) public data: PaymentDialogData) {
    }

    onPayNowClick(): void {
        console.log('PayNow was clicked');
        this.data.paymentSuccessful = true;
        this.dialogRef.close(this.data);
    }

    onPayLaterClick(): void {
        console.log('PayLater was clicked');
        this.data.paymentSuccessful = false;
        this.dialogRef.close(this.data);
    }

    ngOnInit() {
    }

}
