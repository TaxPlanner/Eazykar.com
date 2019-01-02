import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Principal } from 'app/core';
import { ItrApplicationService } from 'app/main/pages/application-list/itr-application.service';
import { IItrApplication } from 'app/shared/model/itr-application.model';

@Component({
    selector: 'ezkr-application-list',
    templateUrl: './application-list.component.html',
    styleUrls: ['./application-list.component.scss']
})
export class ApplicationListComponent implements OnInit {

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    displayedColumns: string[] = ['applicationNumber', 'user', 'assignee', 'action'];
    dataSource: MatTableDataSource<IItrApplication>;

    constructor(private itrApplicationService: ItrApplicationService,
                private principal: Principal) {
    }

    ngOnInit() {

        this.principal.identity().then(account => {
            let criteria = {};
            if (this.principal.hasAnyAuthorityDirect(['CA_MANAGER'])) {
                criteria = { 'id.greaterThan': 0 };
            } else {
                criteria = { 'assigneeId.equals': account.id };
            }

            this.itrApplicationService.query(criteria)
                .subscribe((response) => {
                    this.dataSource = new MatTableDataSource(response.body);
                    this.dataSource.paginator = this.paginator;
                    this.dataSource.sort = this.sort;
                });
        });
    }
}
