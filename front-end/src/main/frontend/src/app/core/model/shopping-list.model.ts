import { Injectable } from "@angular/core";
import { Item } from "./item.model";
import { User } from "./user.model";

@Injectable()
export class ShoppingList {
	
   // public items: Items[] = [];

//    public itemCount: number = 0;
//
//	public user: User;
//
//    addItem(item: Item, quantity: number = 1) {
//    	
//        let item = this.items.find(item => items.item.id == item.id);
//        
//        if (item != undefined) {
//            item.quantity += quantity;
//        } else {
//            this.items.push(item);
//        }
//        this.itemCount += quantity;
//        
//    }
//    
//    removeItem(id: number) {
//    	
//        let index = this.items.findIndex(item => item.item.id == id);
//        this.items.splice(index, 1);
//        
//        this.itemCount -= 1;
//        
//    }
//    
//    clear() {
//        this.items = [];
//        this.itemCount = 0;
//     
//    }
}