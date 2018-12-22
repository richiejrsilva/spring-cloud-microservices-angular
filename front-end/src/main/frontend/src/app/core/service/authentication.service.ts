import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { CommonUtil } from '../utilities/common.util';

@Injectable()
export class AuthenticationService {
	
	private _baseUrl: string;

    constructor(private http: HttpClient) { 
    	this._baseUrl = CommonUtil.getApiUrl("OAUTH_SERVICE");
    }

    login(username: string, password: string) {
    	
        return this.http.post<any>(`this._baseUrl`, { username: username, password: password })
            .pipe(map(user => {
                
            	// login successful if there's a jwt token in the response
                if (user && user.token) {
                	
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    
                }

                return user;
                
            }));
    }

    logout() {
    	
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        
    }
}