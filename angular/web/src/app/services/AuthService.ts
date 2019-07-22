import {Injectable} from '@angular/core';
import {LoginForm} from '../interfaces/loginForm';
import {API_URL} from '../app.constants';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Router} from '@angular/router';

export const TOKEN = 'token'

import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable()
export class AuthService {

 helper = new JwtHelperService();


  constructor(private router : Router,  private http:HttpClient) {

              }
  
  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    // Check whether the token is expired and return
    // true or false
    return !this.helper.isTokenExpired(token);
  }

  executeJWTAuthenticationService(username, password) {


    return this.http.post<any>(
      `${API_URL}/company/company/loginCompany`,{"userName":username,"password":password}).pipe(
      map(
        data => {
          sessionStorage.setItem(TOKEN, `Bearer ${data["result"]["accessToken"]}`);
          return data;
        }
      )
    );
  }





  getAuthenticatedToken() {
    if(sessionStorage.getItem(TOKEN))
      return sessionStorage.getItem(TOKEN)
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(TOKEN)
    return !(user === null)
  }

  logout(){
    sessionStorage.removeItem(TOKEN)
    this.router.navigate(['login'])
  }

}
