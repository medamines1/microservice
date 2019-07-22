import { Component, OnInit } from '@angular/core';
import Swal from "sweetalert2";
import {Router} from '@angular/router';

import {RegisterService} from '../services/register.service';
import {AuthService} from '../services/AuthService';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  userName : string ;
  password : string ;
  errorMessage : string = "invalid credential";
  invalidLogin : boolean = false;

  constructor(private router: Router,
              private authService:AuthService) { }

  ngOnInit() {
    }

  handleJWTAuthLogin() {
    this.authService.executeJWTAuthenticationService(this.userName, this.password)
      .subscribe(
        data => {
          console.log(data["result"]["accessToken"])
          this.invalidLogin = false
          this.router.navigate(['dashboard'])

        },
        error => {
          console.log(error)
          this.invalidLogin = true
          Swal.fire({
            title:"Fail To login ",
            type:"error",
          });
        }
      )
  }
  }




