


import { HttpClient } from '@angular/common/http';

import { UserInt } from '../interfaces/User';

import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
  })
export class SettingsService  {
  constructor(private http:HttpClient) {


  }

  public makeChanges(User:UserInt):any{  
   return this.http.put("http://localhost:8100/company/update/"+ User.id, User);
  }

}