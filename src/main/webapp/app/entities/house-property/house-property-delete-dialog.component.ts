import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IHouseProperty } from 'app/shared/model/house-property.model';
import { HousePropertyService } from './house-property.service';

@Component({
    selector: 'ezkr-house-property-delete-dialog',
    templateUrl: './house-property-delete-dialog.component.html'
})
export class HousePropertyDeleteDialogComponent {
    houseProperty: IHouseProperty;

    constructor(
        private housePropertyService: HousePropertyService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.housePropertyService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'housePropertyListModification',
                content: 'Deleted an houseProperty'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'ezkr-house-property-delete-popup',
    template: ''
})
export class HousePropertyDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ houseProperty }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(HousePropertyDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.houseProperty = houseProperty;
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
