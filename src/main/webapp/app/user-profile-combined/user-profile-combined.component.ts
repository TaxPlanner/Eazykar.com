import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'ezkr-user-profile-combined',
  templateUrl: './user-profile-combined.component.html',
  styleUrls: [
    'user-profile-combined.scss'
  ]
})
export class UserProfileCombinedComponent implements OnInit {

  message: string;

  constructor() {
    this.message = 'UserProfileCombinedComponent message';
  }

  ngOnInit() {
  }

}
