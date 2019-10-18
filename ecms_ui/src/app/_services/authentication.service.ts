import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { UserSubject } from '../_models/UserSubject';
import { environment } from 'src/environments/environment.prod';
import { LoginUser } from '../_models/LoginUser';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Role } from '../_models/Role';

const API_URL = environment.apiUrl;

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    
    loginUserURI = API_URL + '/api/v1/token/generate';

    private currentUserSubject: BehaviorSubject<UserSubject> = new BehaviorSubject<UserSubject>({username: '', token: '', roles: []});
    private currentUser: Observable<UserSubject>;
    
    constructor(private http: HttpClient) { 
        if(!!localStorage.getItem('currentUser')) {
            this.currentUserSubject = new BehaviorSubject<UserSubject>(JSON.parse(localStorage.getItem('currentUser')));
        }
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): UserSubject {
        return this.currentUserSubject && this.currentUserSubject.value;
    }

    login(loginPayload: LoginUser) {
        return this.http.post<any>(this.loginUserURI, loginPayload)
            .pipe(
                map(data => {
                    // login successful if there's a jwt token in the response
                    if (data.result && data.result.token) {
                        // store user details and jwt token in local storage to keep user logged in between page refreshes
                        localStorage.setItem('currentUser', JSON.stringify(data.result));
                        this.currentUserSubject && this.currentUserSubject.next(data.result);
                    }
                    
                    return data.result;
                })
           );
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }

    getReturnUrl() {
        let returnUrl = '';
        // redirect to home if already logged in
        if (this.currentUserValue) { 
            let roles:any = this.currentUserValue.roles;
            
            if(roles.includes(Role.Admin)){
                returnUrl = "admin";
            } else if(roles.includes(Role.User)) {
                returnUrl = "student";
            } else {
                returnUrl = '';
            }
        }
        return returnUrl;
    }
    
}