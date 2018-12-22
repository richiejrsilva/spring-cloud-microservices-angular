import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html'
})
export class FooterComponent {
	
  private authorName = "richiejrsilva";
  
  private authorWebSite = "https://www.linkedin.com/in/richardjrsilva/";
  
  private welcomeSentence = "Created for assessment purposes by";
  
  getAuthorName() {
	    return this.authorName;
	  }
  
  getAuthorWebSite() {
	    return this.authorWebSite;
	  }
  
  getWelcomeSentence() {
	    return this.welcomeSentence;
	  }
  
}
