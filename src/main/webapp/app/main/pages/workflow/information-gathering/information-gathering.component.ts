import { Component, Input, OnInit } from '@angular/core';
import { IUser } from 'app/core';

@Component({
    selector: 'ezkr-information-gathering',
    templateUrl: './information-gathering.component.html',
    styleUrls: ['./information-gathering.component.scss']
})
export class InformationGatheringComponent implements OnInit {

    selectedTabIndex = 0;

    @Input() client: IUser;

    constructor() {
    }

    ngOnInit(): void {
    }

}
