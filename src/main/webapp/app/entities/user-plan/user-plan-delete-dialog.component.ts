import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IUserPlan } from 'app/shared/model/user-plan.model';
import { UserPlanService } from './user-plan.service';

@Component({
    selector: 'ezkr-user-plan-delete-dialog',
    templateUrl: './user-plan-delete-dialog.component.html'
})
export class UserPlanDeleteDialogComponent {
    userPlan: IUserPlan;

    constructor(private userPlanService: UserPlanService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.userPlanService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'userPlanListModification',
                content: 'Deleted an userPlan'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'ezkr-user-plan-delete-popup',
    template: ''
})
export class UserPlanDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ userPlan }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(UserPlanDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.userPlan = userPlan;
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
