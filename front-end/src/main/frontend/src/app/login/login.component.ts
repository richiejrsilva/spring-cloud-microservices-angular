import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from "@angular/router";
import { first } from "rxjs/operators";

import { AuthenticationService } from '../core/service/authentication.service';
import { AlertService } from '../core/service/alert.service';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
	
	loginForm: FormGroup;

	submitted = false;

	loading = false;
	
	returnUrl: string;

	constructor(
	        private formBuilder: FormBuilder,
	        private router: Router,
	        private alertService: AlertService,
	        private authenticationService: AuthenticationService) {}

	ngOnInit() {
        this.loginForm = this.formBuilder.group({
        	email: ['', [ Validators.required, Validators.email ]],
            password: ['', Validators.required],
            remember: ['']
        });
	}
	
	// convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }
    
	onSubmit() {
		
	    this.submitted = true;
	    
	    console.log(this.loginForm.controls.remember.value);
	    if (this.loginForm.invalid) {
	      return;
	    }
	    
	    this.loading = true;
	    
//        this.userService.register(this.loginForm.value)
//            .pipe(first())
//            .subscribe(
//                data => {
//                    this.alertService.success('Registration successful', true);
//                    this.router.navigate(['/login']);
//                },
//                error => {
//                    this.alertService.error(error);
//                    this.loading = false;
//                });
	    
	  }
	
}
