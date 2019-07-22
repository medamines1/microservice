import { Component, OnInit } from '@angular/core';
import {UserRegistration} from '../interfaces/UserRegistration';
import {AuthService} from '../services/AuthService';
import {ActivatedRoute, Router} from '@angular/router';
import {RegisterService} from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

   name: string ;
   email : string ;
   userName : string ;
   password : string ;

  constructor(private registerService: RegisterService,
              private router: Router) { }

  ngOnInit() {

  }

  saveUser() {
    console.log(name);

      this.registerService.createCompany(this.name,this.email,this.userName,this.password)
        .subscribe (
          data => {
            console.log(data)
            this.router.navigate(['login'])
          },
            error => {
            console.log(error)
    }

        )

  }
}
