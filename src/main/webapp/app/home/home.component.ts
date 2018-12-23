import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Account, LoginModalService, Principal } from 'app/core';
import { IImage } from 'ng-simple-slideshow';

@Component({
    selector: 'ezkr-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    imageUrls: (string | IImage)[] = [
        { url: 'content/images/carousel/1.png', backgroundSize: 'contain', backgroundPosition: 'center' },
        { url: 'content/images/carousel/2.png', backgroundSize: 'contain', backgroundPosition: 'center' },
        { url: 'content/images/carousel/3.png', backgroundSize: 'contain', backgroundPosition: 'center' },
        { url: 'content/images/carousel/4.png', backgroundSize: 'contain', backgroundPosition: 'center' },
        { url: 'content/images/carousel/5.png', backgroundSize: 'contain', backgroundPosition: 'center' },
        { url: 'content/images/carousel/6.png', backgroundSize: 'contain', backgroundPosition: 'center' }
    ];

    constructor(private principal: Principal, private loginModalService: LoginModalService, private eventManager: JhiEventManager) {
    }

    ngOnInit() {
        this.principal.identity().then(account => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.principal.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }
}
