import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'ezkr-landing',
  templateUrl: './landing.component.html',
  styleUrls: [
    'landing.scss'
  ]
})
export class LandingComponent implements OnInit {

  message: string;

  constructor() {
    this.message = 'LandingComponent message';
  }

  ngOnInit() {
  }

}
