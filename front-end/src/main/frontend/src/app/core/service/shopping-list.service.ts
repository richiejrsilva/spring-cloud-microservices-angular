import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { ShoppingList } from "../model/shopping-list.model";
import { BaseService } from './base.service';

@Injectable()
export class ShoppingListService extends BaseService<ShoppingList> {
	
 
  constructor(httpClient: HttpClient) {
	    super('SHOPPING_LIST_SERVICE', httpClient);
	  }
  
  getTotalShoppingListItems() {
    return this._httpClient.get(`${this._baseUrl}/items/total`);
  }
  
}