import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISalaryInformation } from 'app/shared/model/salary-information.model';
import { SalaryInformationService } from './salary-information.service';

@Component({
    selector: 'ezkr-salary-information-delete-dialog',
    templateUrl: './salary-information-delete-dialog.component.html'
})
export class SalaryInformationDeleteDialogComponent {
    salaryInformation: ISalaryInformation;

    constructor(
        private salaryInformationService: SalaryInformationService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.salaryInformationService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'salaryInformationListModification',
                content: 'Deleted an salaryInformation'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'ezkr-salary-information-delete-popup',
    template: ''
})
export class SalaryInformationDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ salaryInformation }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SalaryInformationDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.salaryInformation = salaryInformation;
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
