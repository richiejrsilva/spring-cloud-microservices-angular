import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from "../model/user.model";
import { BaseService } from './base.service';

@Injectable()
export class UserService extends BaseService<User> {
	
 
  constructor(httpClient: HttpClient) {
	    super('USER_SERVICE', httpClient);
	  }

}