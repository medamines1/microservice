import { Component, OnInit } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from '../services/AuthService';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['../app.component.scss','./dashboard.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class DashboardComponent implements OnInit {


  message = 'Some Welcome Message'
  welcomeMessageFromService:string
  name = ''
  constructor(private  route:ActivatedRoute,
              public authService : AuthService) { }

  ngOnInit() {

   this.name = this.route.snapshot.params["name"]
  }

}
