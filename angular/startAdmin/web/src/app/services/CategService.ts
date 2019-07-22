


import { HttpClient } from '@angular/common/http';



import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
  })
export class CategService  {
  constructor(private http:HttpClient) {
  }

  public getAllUsers(idCateg:String){
    return this.http.get<any[]>("http://localhost:8000/allEmployees/" +  idCateg);

  }

  public getAllCateg(Userid:String){
    return this.http.get<any[]>("http://localhost:8100/company/getAllCategories/"+ Userid);

    }

}