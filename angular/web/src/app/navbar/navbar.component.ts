import { Component, OnInit } from '@angular/core';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Router } from '@angular/router';

import {AuthService} from '../services/AuthService';


@Injectable()
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [NgbDropdownConfig]
})
export class NavbarComponent implements OnInit {
  public sidebarOpened = false;
  public  notificationsList = [];
  public RequestsList =[];
  /*public RequestsList=[
    { 
      id:1,
      name:"proxym-it",
      action:"wanna add you to our category",
    },

    {
      id:2,
      name:"goole-it",
      action:"wanna add you to our category",
    },

    {
      id:3,
      name:"facebook-it",
      action:"wanna add you to our category",
    },
    
  ];*/
  public NumberOfrequests=this.RequestsList.length;
;
  

   
  public numberOfNotifiUnseen = Object.keys(this.notificationsList).length;
  toggleOffcanvas() {
    this.sidebarOpened = !this.sidebarOpened;
    if (this.sidebarOpened) {
      document.querySelector('.sidebar-offcanvas').classList.add('active');
    }
    else {
      document.querySelector('.sidebar-offcanvas').classList.remove('active');
    }
  }



  constructor(config: NgbDropdownConfig,private http: HttpClient,
    private router: Router,
    private authService:AuthService) {
    config.placement = 'bottom-right';

 this.http.get("http://10.20.0.170:8765/notification/notification/getAllByCompId").subscribe((res : Response)=>{
    this.notificationsList = res["result"];
    
    console.log(res);
    this.numberOfNotifiUnseen = this.count(res["result"]);
 });

/*
 this.http.get("http://10.20.0.170:8765/joinrq/joinrq/findByCompId/").subscribe((res : Response)=>{
  this.RequestsList = res["result"];
  
  console.log(res);
  this.NumberOfrequests =this.RequestsList.length;
   
 
});


*/



  }
  ngOnInit() {
  }

  count(data :any[]):number{
    var n:number = 0;
    data.forEach(elm => {
      console.log(elm["seen"]);
      
      if(elm["seen"] == false)
       n = n +1;
    })
   return n;    
 }


 


 getHeaderStyle (){
    if (this.router.url.includes('/profile'))
      return 'ColorRed';
    
    else if (this.router.url.includes('/employee')){
      return 'ColorPurple';
    }
   else if (this.router.url.includes('/settings'))
    return 'ColorGreen';
   else 
    return 'ColorBlue'
 
 
  }

  evaluate(choice:string,id:string){
    console.log(choice,id);

    document.getElementById(id).remove();

    
    if (choice=="accept")
        return "accept";
    else
      return "refuse";


  }

  logout(){
    this.authService.logout();
  }

}
