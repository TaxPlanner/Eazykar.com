import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { LoginModalService } from 'app/core';
import { ActivateService } from './activate.service';

@Component({
    selector: 'ezkr-activate',
    templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit {
    error: string;
    success: string;

    constructor(private activateService: ActivateService,
                private loginModalService: LoginModalService,
                private route: ActivatedRoute,
                private router: Router) {}

    ngOnInit() {
        this.route.queryParams.subscribe(params => {
            this.activateService.get(params['key']).subscribe(
                () => {
                    this.error = null;
                    this.success = 'OK';
                },
                () => {
                    this.success = null;
                    this.error = 'ERROR';
                }
            );
        });
    }

    login() {
        this.router.navigate(['sign-in']);
    }
}
