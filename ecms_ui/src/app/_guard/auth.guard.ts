import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router
    ){}
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        let token = window.localStorage.getItem('token');
        if(!token) {
            this.router.navigate(['/']);
            return false;
        } else {
            return true;
        }
    }

}