import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './not-found/not-found.component';
import { LoginComponent }  from './login/login.component';
import { SignUpComponent }  from './signup/signup.component';

import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AboutModule }      from './about/about.module';
import { DashboardModule }      from './dashboard/dashboard.module';
import { DocumentationModule }      from './documentation/documentation.module';
import { LogOutModule }      from './logout/logout.module';
import { ShoppingListModule }      from './shopping-list/shopping-list.module';
import { CoreModule }      from './core/core.module';

import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    LoginComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AboutModule,
    DashboardModule,
    DocumentationModule,
    LogOutModule,
    ShoppingListModule,
    CoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
