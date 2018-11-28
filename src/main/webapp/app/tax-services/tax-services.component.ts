import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'ezkr-tax-services',
  templateUrl: './tax-services.component.html',
  styleUrls: [
    'tax-services.scss'
  ]
})
export class TaxServicesComponent implements OnInit {

  message: string;

  constructor() {
    this.message = 'TaxServicesComponent message';
  }

  ngOnInit() {
  }

}
