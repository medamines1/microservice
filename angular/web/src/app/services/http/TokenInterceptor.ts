
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';


import { AuthService } from '../AuthService';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(public auth: AuthService) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.auth.getAuthenticatedToken() !=undefined)    
  {  
    console.log("intercepting request with bearer : " + this.auth.getAuthenticatedToken());
    
    request = request.clone({
      setHeaders: {
        Authorization: `${this.auth.getAuthenticatedToken()}`
      }
    });

  }
    return next.handle(request);
  }
}