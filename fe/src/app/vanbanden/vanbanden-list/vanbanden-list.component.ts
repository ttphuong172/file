import { Component, OnInit } from '@angular/core';
import {VanbandenService} from "../../../service/vanbanden.service";
import {JwtHelperService} from "@auth0/angular-jwt";
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-vanbanden-list',
  templateUrl: './vanbanden-list.component.html',
  styleUrls: ['./vanbanden-list.component.css']
})
export class VanbandenListComponent implements OnInit {
  vanBanDens:any
  constructor(
    private vanbandenService:VanbandenService,
    private jwtHelperService:JwtHelperService,
    private authService:AuthService,
    private router:Router
  ) { }

  ngOnInit(): void {
    // @ts-ignore
    if (this.jwtHelperService.isTokenExpired(this.authService.getToken())){
      this.router.navigateByUrl("")
    } else {
      this.vanbandenService.findAll().subscribe(
        (data)=>{
          console.log(data);
          this.vanBanDens=data;
        }
      )
    }

  }

}
