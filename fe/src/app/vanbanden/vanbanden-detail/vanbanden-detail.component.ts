import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {VanbandenService} from "../../../service/vanbanden.service";
import {AccountService} from "../../../service/account.service";
import {AuthService} from "../../../service/auth.service";
import {JwtHelperService} from "@auth0/angular-jwt";

@Component({
  selector: 'app-vanbanden-detail',
  templateUrl: './vanbanden-detail.component.html',
  styleUrls: ['./vanbanden-detail.component.css']
})
export class VanbandenDetailComponent implements OnInit {
  vanBanDen: any;
  account: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private vanbandenService: VanbandenService,
    private accountService: AccountService,
    protected authService: AuthService,
    private jwtHelperService: JwtHelperService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = String(this.activatedRoute.snapshot.paramMap.get('id'));
    // @ts-ignore
    if (this.jwtHelperService.isTokenExpired(this.authService.getToken())) {
      this.router.navigateByUrl("")
    } else {
      this.vanbandenService.findById(id).subscribe(
        (data) => {
          this.vanBanDen = data;
        }
      )
    }
  }

}
