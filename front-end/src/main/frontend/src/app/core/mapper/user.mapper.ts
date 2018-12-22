import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { User } from "../model/user.model";


@Injectable()
export class UserMapper {

	constructor() {}

	mapFormToUser(form: FormGroup) {
		return new User(null,
				form.get('name').value,
				form.get('email').value,
				form.get('password').value);
		}

}