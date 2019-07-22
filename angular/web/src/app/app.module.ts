import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MysidebarComponent } from './mysidebar/mysidebar.component';

import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { EmployeeComponent } from './employee/employee.component';  


import { SettingsService } from '../app/services/SettingsSrv';
import { CategService} from '../app/services/CategService';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { CategorieComponent } from './categorie/categorie.component';





import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ErrorComponent } from './error/error.component';
import {AuthService} from './services/AuthService';



import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './services/http/TokenInterceptor'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    DashboardComponent,
    LoginPageComponent,
    MysidebarComponent,
    RegisterComponent,
    ProfileComponent,
    SettingsComponent,
    EmployeeComponent,
    CategorieComponent,
    ErrorComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    Ng2SmartTableModule,
    SweetAlert2Module.forRoot(),
    NgbModule.forRoot()
  ],
  exports: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    DashboardComponent,
  ],
  providers: [
    SettingsService,
    CategService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
