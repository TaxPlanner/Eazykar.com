import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'ezkr-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

    selectedTabIndex = 0;

    constructor(private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(({ selectedTabIndex }) => this.selectedTabIndex = selectedTabIndex);
    }

}
