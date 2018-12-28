import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FuseConfigService } from 'app/@fuse/services/config.service';

@Component({
    selector: 'ezkr-error',
    templateUrl: './error.component.html',
    styleUrls: ['./error.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class ErrorComponent implements OnInit {
    errorMessage: string;
    error403: boolean;

    constructor(
        private _fuseConfigService: FuseConfigService,
        private route: ActivatedRoute
    ) {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar: {
                    hidden: true
                },
                toolbar: {
                    hidden: true
                },
                footer: {
                    hidden: true
                },
                sidepanel: {
                    hidden: true
                }
            }
        };
    }

    ngOnInit() {
        this.route.data.subscribe(routeData => {
            if (routeData.error403) {
                this.error403 = routeData.error403;
            }
            if (routeData.errorMessage) {
                this.errorMessage = routeData.errorMessage;
            }
        });
    }
}
