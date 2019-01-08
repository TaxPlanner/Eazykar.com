import { ChangeDetectorRef, Component, OnInit, QueryList, ViewChildren, ViewEncapsulation } from '@angular/core';
import { fuseAnimations } from 'app/@fuse/animations';
import { FuseSidebarService } from 'app/@fuse/components/sidebar/sidebar.service';
import { FusePerfectScrollbarDirective } from 'app/@fuse/directives/fuse-perfect-scrollbar/fuse-perfect-scrollbar.directive';
import { SalaryInformationService } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information.service';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
    selector: 'ezkr-workflow',
    templateUrl: './workflow.component.html',
    styleUrls: ['./workflow.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class WorkflowComponent implements OnInit {

    animationDirection: 'left' | 'right' | 'none';
    tabStepContent: any;
    steps = [
        {
            title: 'Information Gathering'
        },
        {
            title: 'Application Assignment'
        },
        {
            title: 'ITR Preparation'
        },
        {
            title: 'Client Review'
        },
        {
            title: 'Client Approval'
        },
        {
            title: 'ITR Submission'
        },
        {
            title: 'E-Verification'
        },
        {
            title: 'Client Sign Off'
        },
        {
            title: 'Eazykar Sign Off'
        }
    ];
    currentStep: number;

    @ViewChildren(FusePerfectScrollbarDirective)
    fuseScrollbarDirectives: QueryList<FusePerfectScrollbarDirective>;

    // Private
    private _unsubscribeAll: Subject<any>;

    constructor(
        private salaryInformationService: SalaryInformationService,
        private _changeDetectorRef: ChangeDetectorRef,
        private _fuseSidebarService: FuseSidebarService
    ) {
        // Set the defaults
        this.animationDirection = 'none';
        this.currentStep = 0;

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {

        // Subscribe to tabs
        this.salaryInformationService.query({})
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(tab => {
                // this.tab = tab;
            });
    }

    /**
     * After view init
     */
    ngAfterViewInit(): void {
        this.tabStepContent = this.fuseScrollbarDirectives.find((fuseScrollbarDirective) => {
            return fuseScrollbarDirective.elementRef.nativeElement.id === 'course-step-content';
        });
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Go to step
     *
     * @param step
     */
    gotoStep(step): void {
        // Decide the animation direction
        this.animationDirection = this.currentStep < step ? 'left' : 'right';

        // Run change detection so the change
        // in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Set the current step
        this.currentStep = step;
    }

    /**
     * Go to next step
     */
    gotoNextStep(): void {
        if (this.currentStep === this.steps.length - 1) {
            return;
        }

        // Set the animation direction
        this.animationDirection = 'left';

        // Run change detection so the change
        // in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Increase the current step
        this.currentStep++;
    }

    /**
     * Go to previous step
     */
    gotoPreviousStep(): void {
        if (this.currentStep === 0) {
            return;
        }

        // Set the animation direction
        this.animationDirection = 'right';

        // Run change detection so the change
        // in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Decrease the current step
        this.currentStep--;
    }

    /**
     * Toggle the sidebar
     *
     * @param name
     */
    toggleSidebar(name): void {
        this._fuseSidebarService.getSidebar(name).toggleOpen();
    }
}
