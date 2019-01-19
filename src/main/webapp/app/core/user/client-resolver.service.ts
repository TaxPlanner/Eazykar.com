import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { IUser, Principal } from 'app/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ClientResolverService implements Resolve<IUser> {

    constructor(private principal: Principal) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IUser> | Promise<IUser> | IUser {
        if (this.principal.isAuthenticated()) {
            if (this.principal.hasAnyAuthorityDirect(['ROLE_CA', 'ROLE_CA_MANAGER'])) {
                return null;
            }
            return this.principal.identity();
        }
        return null;
    }
}
