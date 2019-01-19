import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, Sort } from '@angular/material';
import { Router } from '@angular/router';
import { IUser, Principal, UserService } from 'app/core';
import { ItrApplicationService } from 'app/main/pages/application-list/itr-application.service';
import { IItrApplication } from 'app/shared/model/itr-application.model';
import { take } from 'rxjs/operators';

@Component({
    selector: 'ezkr-application-list',
    templateUrl: './application-list.component.html',
    styleUrls: ['./application-list.component.scss']
})
export class ApplicationListComponent implements OnInit {

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    displayedColumns: string[] = [
        'applicationNumber',
        'user',
        'assignee',
        'applicationStatus',
        'action'
    ];
    dataSource: MatTableDataSource<IItrApplication>;
    caList: IUser[] = [];

    constructor(private itrApplicationService: ItrApplicationService,
                private userService: UserService,
                private router: Router,
                private principal: Principal) {
    }

    ngOnInit() {

        this.userService.findCAs()
            .subscribe(({ body }) => {
                this.caList = body;
                this.loadApplicationList();
            });
    }

    private loadApplicationList() {
        if (this.principal.hasAnyAuthorityDirect(['ROLE_CA_MANAGER'])) {
            this.itrApplicationService.query({ 'id.specified': true })
                .pipe(take(1))
                .subscribe(({ body }) => this.setDataSource(body));
        } else {
            this.itrApplicationService.findAllForCurrentUser()
                .pipe(take(1))
                .subscribe(({ body }) => this.setDataSource(body));
        }
    }

    private setDataSource(itrApplications: IItrApplication[]) {
        this.dataSource = new MatTableDataSource(itrApplications);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    }

    assignToSelf(row: IItrApplication) {

        this.principal.identity()
            .then(user => {
                row.assignee = user;
                this.itrApplicationService.update(row).subscribe();
            });
    }

    assignToCA(row: IItrApplication) {
        this.itrApplicationService.update(row).subscribe();
    }

    continueWorking(row: IItrApplication) {
        this.router.navigate(['pages', 'workflow'], { queryParams: { currentStep: 2 } });
    }

    sortData(sort: Sort) {
        const data = this.dataSource.data.slice();
        if (!sort.active || sort.direction === '') {
            this.dataSource.data = data;
            return;
        }

        this.dataSource.data = data.sort((a, b) => {
            const isAsc = sort.direction === 'asc';
            switch (sort.active) {
                case 'applicationNumber':
                    return compare(a.applicationNumber, b.applicationNumber, isAsc);
                case 'user':
                    return compare(`${a.user.firstName} ${a.user.lastName}`, `${b.user.firstName} ${b.user.lastName}`, isAsc);
                case 'assignee':
                    return compare(`${a.assignee.firstName} ${a.assignee.lastName}`, `${b.assignee.firstName} ${b.assignee.lastName}`, isAsc);
                case 'status':
                    return compare(a.applicationStatus, b.applicationStatus, isAsc);
                default:
                    return 0;
            }
        });
    }

    applyFilter(filterValue: string) {
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }

    updateAssignee(row: IItrApplication, $event: any) {
        if (row.assignee) {
            row.assignee.id = +$event;
        } else {
            row.assignee = { id: +$event };
        }
    }

    compareAssigneeIds(o1, o2): boolean {
        return `${o1}` === `${o2}`;
    }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
    return (a < b ? -1 : (a > b ? 1 : 0)) * (isAsc ? 1 : -1);
}
