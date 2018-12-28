import { Injectable } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LoginModalService {
    private isOpen = false;
    constructor(private router: Router,
                private modalService: NgbModal) {}

    open(): NgbModalRef {
        // if (this.isOpen) {
        //     return;
        // }
        // this.isOpen = true;
        // const modalRef = this.modalService.open(EzkrLoginModalComponent);
        // modalRef.result.then(
        //     result => {
        //         this.isOpen = false;
        //     },
        //     reason => {
        //         this.isOpen = false;
        //     }
        // );
        // return modalRef;

        this.router.navigate(['pages', 'auth', 'login-2']);
        return null;
    }
}
