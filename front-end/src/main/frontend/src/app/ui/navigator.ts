export class Navigator {
	
    private navItems;
    
    constructor() {
    	
        this.navItems = [
        	new NavItem("/dashboard", "Dashboard"),
        	new NavItem("/documentation", "Documentation"),
        	new NavItem("/about", "About"),
        	new NavItem("/login", "Login"),
        	new NavItem("/shopping-list", "Shopping List"),
        	new NavItem("/logout", "Logout")
        	]
        
    }
    
    getNavItems() {
    	return this.navItems;
    }
}

export class NavItem {
	
    private pathDescriptor;
    
    private label;
    
    constructor(pathDescriptor, label) {
        this.pathDescriptor = pathDescriptor;
        this.label = label;
    }
    
    getPathDescriptor() {
    	return this.pathDescriptor;
    }
    
    getLabel() {
    	return this.label;
    }
    
}
