import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { LoginUser } from '../models/LoginUser';
import { ApiResponse } from '../models/ApiResponse';
import { environment } from '../../environments/environment';

const API_URL = environment.apiUrl;

@Injectable({
    providedIn: 'root'
})

export class UserService {
	    
    registerUserURI = API_URL + '/api/v1/users/register';    
    loginUserURI = API_URL + '/api/v1/token/generate';

    constructor(private http: HttpClient) { }
    
    createUser(user: User): Observable<ApiResponse> {
        return this.http.post<ApiResponse>(this.registerUserURI, user);
    }

    loginUser(loginPayload: LoginUser): Observable<ApiResponse> {
        return this.http.post<ApiResponse>(this.loginUserURI, loginPayload);
    }

}
