


import { HttpClient } from '@angular/common/http';



import { Injectable } from '@angular/core';
import { categInt } from '../interfaces/categInt';

import { URLSearchParams } from "@angular/http"

@Injectable({
    providedIn: 'root',
  })
export class CategService  {

 
  constructor(private http:HttpClient) {
  }

  public sendRequestToUser(id:String) {
    let data = {};
    data["userid"] = id;
    return this.http.post<any[]>("http://10.20.0.170:8765/joinrq/joinrq/insert",data);
  }

  public getAllUsers(idCateg:String){
    return this.http.get<any[]>("http://10.20.0.170:8765/employee/employee/allEmployees/" +  idCateg);

  }

  getUserByphoneNumber(idc:String) {
    return this.http.get<any[]>("http://10.20.0.170:8765/employee/employee/employee/byphone/"+idc);
  }

  public getAllCateg(){
    return this.http.get<any[]>("http://10.20.0.170:8765/company/companyApi/getAllCategories/");

    }

    public save(element:categInt){
      let data = {};
      data["id"]=element.id;
      data["name"]=element.name;
      data["description"]=element.description;
      data["balance"]=element.balance;
      data["date"]=element.date;

      return this.http.post<any[]>("http://10.20.0.170:8765/category/categoryApi/addCategory/",element);
    }


    public update(element:categInt,idcomp:string){
      let data = {};
      data["id"]=element.id;
      data["name"]=element.name;
      data["description"]=element.description;
      data["balance"]=element.balance;
      data["date"]=element.date;

      return this.http.put<any[]>("http://10.20.0.170:8765/category/category/updateCategoryBycategForm/"+element.id,element);
    }


    public delete(element:categInt){
    console.log(element.id);

      return this.http.delete<any[]>("http://10.20.0.170:8765/category/categoryApi/category/"+element.id);
    }


}