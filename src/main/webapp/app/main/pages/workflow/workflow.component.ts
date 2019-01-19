import { ChangeDetectorRef, Component, OnInit, QueryList, ViewChildren, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { fuseAnimations } from 'app/@fuse/animations';
import { FuseSidebarService } from 'app/@fuse/components/sidebar/sidebar.service';
import { FusePerfectScrollbarDirective } from 'app/@fuse/directives/fuse-perfect-scrollbar/fuse-perfect-scrollbar.directive';
import { IUser } from 'app/core';
import { SalaryInformationService } from 'app/main/pages/workflow/information-gathering/salary-information/salary-information.service';
import { Subject } from 'rxjs';

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
    /*
        clientSteps = [
            { title: 'Information Gathering' },
            { title: 'Application Assignment' },
            { title: 'Client Review' },
            { title: 'Client Approval' },
            { title: 'ITR Submission' },
            { title: 'E-Verification' },
            { title: 'Client Sign Off' },
            { title: 'Eazykar Sign Off' }
        ];
        caSteps = [
            { title: 'Application Assignment' },
            { title: 'Information Provided' },
            { title: 'ITR Preparation' },
            { title: 'ITR Submission' },
            { title: 'E-Verification' },
            { title: 'Eazykar Sign Off' }
        ];
    */
    steps = [
        { title: 'Information Gathering' },
        { title: 'Application Assignment' },
        { title: 'ITR Preparation' },
        { title: 'Client Review' },
        { title: 'Client Approval' },
        { title: 'ITR Submission' },
        { title: 'E-Verification' },
        { title: 'Client Sign Off' },
        { title: 'Eazykar Sign Off' }
    ];

    currentStep: number;
    client: IUser = {};

    @ViewChildren(FusePerfectScrollbarDirective)
    fuseScrollbarDirectives: QueryList<FusePerfectScrollbarDirective>;

    // Private
    private _unsubscribeAll: Subject<any>;

    constructor(private salaryInformationService: SalaryInformationService,
                private _changeDetectorRef: ChangeDetectorRef,
                private route: ActivatedRoute,
                private _fuseSidebarService: FuseSidebarService) {

        // Set the defaults
        this.animationDirection = 'none';
        this.currentStep = 0;

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    ngOnInit(): void {
        // Use cases:

        // 1. If client has logged in
        // -- -- if client is empty, query principle
        // 2. If CA has logged in
        // -- -- if client is empty, take CA to application assignment screen, where client selection occurs
        // 3. If CA Manager has logged in
        // -- -- if client is empty, take CA to application assignment screen, where client selection occurs

        this.route.data.subscribe((data: { client: IUser }) => this.client = data.client);
    }

    ngAfterViewInit(): void {
        this.tabStepContent = this.fuseScrollbarDirectives.find((fuseScrollbarDirective) => {
            return fuseScrollbarDirective.elementRef.nativeElement.id === 'course-step-content';
        });
        this.route.queryParams.subscribe(({ currentStep }) => {
            this.gotoStep(+currentStep);
        });
    }

    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    gotoStep(step): void {
        // Decide the animation direction
        this.animationDirection = this.currentStep < step ? 'left' : 'right';

        // Run change detection so the change in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Set the current step
        setTimeout(() => {
            this.currentStep = step;
        });
    }

    gotoNextStep(): void {
        if (this.currentStep === this.steps.length - 1) {
            return;
        }

        // Set the animation direction
        this.animationDirection = 'left';

        // Run change detection so the change in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Increase the current step
        setTimeout(() => {
            this.currentStep++;
        });
    }

    gotoPreviousStep(): void {
        if (this.currentStep === 0) {
            return;
        }

        // Set the animation direction
        this.animationDirection = 'right';

        // Run change detection so the change in the animation direction registered
        this._changeDetectorRef.detectChanges();

        // Decrease the current step
        setTimeout(() => {
            this.currentStep--;
        });
    }

    toggleSidebar(name): void {
        this._fuseSidebarService.getSidebar(name).toggleOpen();
    }
}
