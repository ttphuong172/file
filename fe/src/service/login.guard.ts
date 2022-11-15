import { Injectable } from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {VanbandenService} from "./vanbanden.service";
import {AccountService} from "./account.service";
import {AuthService} from "./auth.service";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})

export class LoginGuard implements CanActivate {
  constructor(
    private activatedRoute:ActivatedRoute,
    private vanbandenService:VanbandenService,
    private accountService:AccountService,
    protected authService:AuthService,
    private jwtHelperService:JwtHelperService,
  ) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    // @ts-ignore
    const abc= this.jwtHelperService.decodeToken(this.authService.getToken());
    if(abc.role.authority=='ROLE_ADMIN' || abc.role.authority=='ROLE_USER'){
      return true;
    }
    return false;
  }

}
