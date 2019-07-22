import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {API_URL} from '../app.constants';
import {UserRegistration} from '../interfaces/UserRegistration';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  // userRegistration:UserRegistration  = null;
  constructor(private http:HttpClient) { }

  createCompany(name,email,userName,password){
    // this.userRegistration = new UserRegistration(name,email,userName,password)
    return this.http.post<any>(
      `${API_URL}/company/company/addCompany`
      ,{name,email,userName,password});
  }
}
