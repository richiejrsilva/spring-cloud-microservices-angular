import { Component } from '@angular/core';

import { Navigator } from "../ui/navigator";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

	private appTitle = "GameHouse Assessment";
	
	private navbarOpen = false;
	
	private navigator = new Navigator();

	getAppTitle() {
	    return this.appTitle;
	  }
	
	toggleNavbar() {
	    this.navbarOpen = !this.navbarOpen;
	  }
	
	buildNavbar() {
	    return this.navigator.getNavItems();
	  }
	
}
