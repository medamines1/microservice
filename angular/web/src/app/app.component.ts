import { Component } from '@angular/core';


import { Router, NavigationEnd } from '@angular/router';
import {AuthService} from './services/AuthService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {

  constructor(private router: Router ,
              public authService :  AuthService) {

  }
 
}
