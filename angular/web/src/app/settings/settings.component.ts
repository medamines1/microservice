import { Component, OnInit } from '@angular/core';

import { SettingsService } from '../services/SettingsSrv';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  username="";
  name="";
  email = "";
  password="";
  id="ff8080816a4b1eeb016a4b207bcc0000";

  constructor(public settingSrv:SettingsService) { 
    
  }

  ngOnInit() {
  }


  SubmitChanges(){  

    this.settingSrv.makeChanges({
      "id":this.id,
      "username" : this.username,
      "email" : this.email,
      "password" : this.password,
      "balance" : "00",
      "name" : this.name,
      }).subscribe((res : Response)=>{
        console.log(res);
        Swal.fire({
          text:"success",
          type:"success",
        });

  },(err)=>{
    console.log(err);

    Swal.fire({
      text:"fail to answer  ",
      type:"error",
    });
  });
    
  }
}
