import { Component, OnInit, ViewEncapsulation } from '@angular/core';

import { FuseConfigService } from 'app/@fuse/services/config.service';
import { fuseAnimations } from 'app/@fuse/animations';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector     : 'mail-confirm',
    templateUrl  : './mail-confirm.component.html',
    styleUrls    : ['./mail-confirm.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations   : fuseAnimations
})
export class MailConfirmComponent implements OnInit {
    title: string;
    subtitle: string;
    message: string;
    messageLink: string;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {ActivatedRoute} route
     */
    constructor(
        private _fuseConfigService: FuseConfigService,
        private route: ActivatedRoute
    ) {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar   : {
                    hidden: true
                },
                toolbar  : {
                    hidden: true
                },
                footer   : {
                    hidden: true
                },
                sidepanel: {
                    hidden: true
                }
            }
        };
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            console.log(`params: ${JSON.stringify(params)}`);
            this.title = params['title'];
            this.subtitle = params['subtitle'];
            this.message = params['message'];
            this.messageLink = params['messageLink'];
        });
    }
}
