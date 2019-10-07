import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from '../_services/authentication.service';
import { Role } from '../_models/Role';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ){}
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        const currentUser = this.authenticationService.currentUserValue;
        if (currentUser) {
            if(route.data.roles.some((val) => currentUser.roles.indexOf(val) !== -1)  ){
                return true;
            } else {
                // not logged in so redirect to login page with the return url
                this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
                return false;
            }
        } else {
            // not logged in so redirect to login page with the return url
            this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
            return false;
        }
    }

}