import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../../service/account.service";

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {
  accountList:any;
  constructor(
    private accountService:AccountService
  ) { }

  ngOnInit(): void {
    this.accountService.findAll().subscribe(
      (data)=>{
        this.accountList=data;
        console.log(data);
      }
    )
  }

}
