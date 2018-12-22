import { Component } from '@angular/core';

@Component({
  templateUrl: './about.component.html'
})
export class AboutComponent {

	private authorName = "Richard José Rodrigues da Silva";
	
	getAuthorName() {
		return this.authorName;
	}
}
