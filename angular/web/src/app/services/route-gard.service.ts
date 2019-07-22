import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteGardService implements CanActivate{


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return undefined;
  }

  constructor() { }
}
