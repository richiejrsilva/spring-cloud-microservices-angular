import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { ShoppingListService } from "../core/service/shopping-list.service";
import { UserService } from "../core/service/user.service";
import { UserMapper } from "../core/mapper/user.mapper";
import { AlertService } from "../core/service/alert.service";
import { AuthenticationService } from "../core/service/authentication.service";

@NgModule({
  imports: [
    HttpClientModule
  ],

  providers: [
	  ShoppingListService,
	  UserService,
	  UserMapper,
	  AuthenticationService,
	  AlertService
  ],

})
export class CoreModule {}
