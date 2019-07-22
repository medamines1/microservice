import { Component, OnInit } from '@angular/core';

import { SettingsService } from '../services/SettingsSrv';



@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  username="";
  name="";
  password="";
  id="ff8080816a2b0bd3016a2b0c8c690002";

  constructor(public settingSrv:SettingsService) { 
    
  }

  ngOnInit() {
  }


  SubmitChanges(){  

    this.settingSrv.makeChanges({
      "id":this.id,
      "username" : this.username,
      "password" : this.password,
      "balance" : "00",
      "name" : this.name,
    });
    
  }
}
