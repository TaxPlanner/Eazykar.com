import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IItrApplication } from 'app/shared/model/itr-application.model';
import { ItrApplicationService } from './itr-application.service';

@Component({
    selector: 'ezkr-itr-application-delete-dialog',
    templateUrl: './itr-application-delete-dialog.component.html'
})
export class ItrApplicationDeleteDialogComponent {
    itrApplication: IItrApplication;

    constructor(
        private itrApplicationService: ItrApplicationService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.itrApplicationService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'itrApplicationListModification',
                content: 'Deleted an itrApplication'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'ezkr-itr-application-delete-popup',
    template: ''
})
export class ItrApplicationDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ itrApplication }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ItrApplicationDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.itrApplication = itrApplication;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
