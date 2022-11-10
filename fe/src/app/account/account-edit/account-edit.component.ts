import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../../../service/account.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit {
  account:any;
  accountForm: FormGroup | any;
  roleList=["ROLE_ADMIN","ROLE_USER"]
  constructor(
    private activatedRoute:ActivatedRoute,
    private accountService:AccountService
  ) { }

  ngOnInit(): void {
    this.accountForm = new FormGroup({
      username: new FormControl(''),
      name: new FormControl('')
    })


    const username = String(this.activatedRoute.snapshot.paramMap.get('id'));

    this.accountService.findById(username).subscribe(
      (data)=>{
        console.log(data);
        this.account=data;
        this.accountForm.controls['username'].setValue(this.account.username)
        this.accountForm.controls['name'].setValue(this.account.name)
      }
    )
  }

}
