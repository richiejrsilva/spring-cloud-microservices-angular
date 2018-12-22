import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { paths } from './app-config-settings/path.definition';

import { AboutComponent }      from './about/about.component';
import { DashboardComponent }  from './dashboard/dashboard.component';
import { DocumentationComponent }  from './documentation/documentation.component';
import { LoginComponent }  from './login/login.component';
import { ShoppingListComponent }  from './shopping-list/shopping-list.component';
import { LogoutComponent }  from './logout/logout.component';
import { SignUpComponent }  from './signup/signup.component';
import { PageNotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
	  { path: paths.root, redirectTo: paths.dashboard, pathMatch: 'full' },
	  { path: paths.about, component: AboutComponent },
	  { path: paths.dashboard, component: DashboardComponent },
	  { path: paths.documentation, component: DocumentationComponent },
	  { path: paths.login, component: LoginComponent },
	  { path: paths.shoppingList, component: ShoppingListComponent },
	  { path: paths.logout, component: LogoutComponent },
	  { path: paths.signup, component: SignUpComponent },
	  { path: paths.notFound, component: PageNotFoundComponent }
	];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
