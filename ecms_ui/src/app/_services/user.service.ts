import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { User } from '../_models/User';
import { ApiResponse } from '../_models/ApiResponse';

const API_URL = environment.apiUrl;

@Injectable({
    providedIn: 'root'
})

export class UserService {
	
    registerUserURI = API_URL + '/api/v1/users/register';

    constructor(private http: HttpClient) { }
    
    createUser(user: User): Observable<ApiResponse> {
        return this.http.post<ApiResponse>(this.registerUserURI, user);
    }

}
