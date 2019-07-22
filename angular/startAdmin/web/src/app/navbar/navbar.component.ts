import { Component, OnInit } from '@angular/core';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Router } from '@angular/router';

@Injectable()
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [NgbDropdownConfig]
})
export class NavbarComponent implements OnInit {
  public sidebarOpened = false;
  private  notificationsList = [];

   
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
  constructor(config: NgbDropdownConfig,private http: HttpClient,private router: Router) {
    config.placement = 'bottom-right';

 this.http.get("http://localhost:8085/notification/getAll").subscribe((res : Response)=>{
    this.notificationsList = res["result"];
    
    console.log(res);
    this.numberOfNotifiUnseen = this.count(res["result"]);
    console.log(this.count(res["result"]));
    
    
 });
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

}
