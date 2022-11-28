import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {LoginService} from "../../service/login.service";
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";
import { JwtModule,JwtHelperService } from "@auth0/angular-jwt"
import {AccountService} from "../../service/account.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  role:any;
  account:any
  username:any
  formLogin = new FormGroup({
    username: new FormControl(''),
    password: new FormControl()
  });

  constructor(
    private loginService: LoginService,
    private authService:AuthService,
    private router:Router,
    private jwtHelperService:JwtHelperService,
    private accountService:AccountService
  ) {
  }

  ngOnInit(): void {
    // @ts-ignore
   if(!this.jwtHelperService.isTokenExpired(this.authService.getToken())){
     this.router.navigateByUrl("/vanbanden")
   }

  }

  login() {
    this.loginService.login(this.formLogin.value).subscribe(
      (data:any) => {
        this.authService.setToken(data.jwtToken);

        this.router.navigateByUrl("/vanbanden")

        // @ts-ignore
        // const abc= this.jwtHelperService.decodeToken(this.authService.getToken());

      }
        )
  }

}
