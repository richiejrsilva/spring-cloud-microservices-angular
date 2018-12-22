import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from "@angular/router";
import { first } from "rxjs/operators";

import { UserService } from "../core/service/user.service";
import { UserMapper } from "../core/mapper/user.mapper";
import { User } from "../core/model/user.model";
import { paths } from '../app-config-settings/path.definition';

@Component({
  templateUrl: './signup.component.html'
})
export class SignUpComponent {
	
	signUpForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    
	constructor(
	        private formBuilder: FormBuilder,
	        private router: Router,
	        private userService: UserService,
	        private userMapper: UserMapper) {}
	
	ngOnInit() {
	    this.signUpForm = this.formBuilder.group({
	    	email: ['', [ Validators.required, Validators.email ]],
	    	name: ['', Validators.required],
	        password: ['', Validators.required]//should have a validator with min pwd length e.g.. But, not required by the assignment
	    });
	}
	
	// convenience getter for easy access to form fields
	get f() { return this.signUpForm.controls; }
	
	onSubmit() {
	    this.submitted = true;
	    
	    //is valid data on form?
	    if (this.signUpForm.invalid) {
	      return;
	    }
	    
	    //create the new user account
	    let user = this.userMapper.mapFormToUser(this.signUpForm);
	    this.userService.create(user)
	      .subscribe( user => {
	    	  window.alert(user['name'].value);
	    	  this.router.navigate([paths.shoppingList]);
	      });
	    
	  }

}
