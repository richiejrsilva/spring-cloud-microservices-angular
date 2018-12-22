import { Component, OnInit } from '@angular/core';

import { ShoppingListService } from "../core/service/shopping-list.service";
import { UserService } from "../core/service/user.service";

@Component({
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
	
	private totalShoppingLists;
	
	private totalUsers;
	
	private totalItems;
	
	constructor(private shoppingListService: ShoppingListService, private userService: UserService) { }
	
	ngOnInit() {
		
		// the number of shopping lists with at least 1 item in them
	    this.shoppingListService.count()
	      .subscribe( total => {
	    	  this.totalShoppingLists = "Shopping Lists: " + total;
	      });
	    
	    // the number of users registered
	    this.userService.count()
	      .subscribe( total => {
	    	  this.totalUsers =  "Registered Users: " + total;;
	      });
	    
	    // the total number of items in all shopping lists combined
	    this.shoppingListService.getTotalShoppingListItems()
	      .subscribe( total => {
	    	  this.totalItems = "All Items in the Shopping Lists: " + total;
	      });
	    
	    
	  }
	
	getTotalShoppingLists() {
	    return this.totalShoppingLists;
	  }
	
	getTotalUsers() {
	    return this.totalUsers;
	  }
	
	getTotalItems() {
	    return this.totalItems;
	  }
	
}
