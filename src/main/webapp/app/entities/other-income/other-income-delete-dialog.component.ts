import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IOtherIncome } from 'app/shared/model/other-income.model';
import { OtherIncomeService } from './other-income.service';

@Component({
    selector: 'ezkr-other-income-delete-dialog',
    templateUrl: './other-income-delete-dialog.component.html'
})
export class OtherIncomeDeleteDialogComponent {
    otherIncome: IOtherIncome;

    constructor(
        private otherIncomeService: OtherIncomeService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.otherIncomeService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'otherIncomeListModification',
                content: 'Deleted an otherIncome'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'ezkr-other-income-delete-popup',
    template: ''
})
export class OtherIncomeDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ otherIncome }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(OtherIncomeDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.otherIncome = otherIncome;
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
