import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {DepartmentService} from "../../../service/department.service";
import {AccountService} from "../../../service/account.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-account-create',
  templateUrl: './account-create.component.html',
  styleUrls: ['./account-create.component.css']
})
export class AccountCreateComponent implements OnInit {
  accountForm: any;
  account: any;
  roleList=["ROLE_ADMIN","ROLE_USER"]
  departmentList: any;

  constructor(
    private departmentService:DepartmentService,
    private accountService:AccountService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.accountForm = new FormGroup({
      username: new FormControl(''),
      name: new FormControl(''),
      role:new FormControl(''),
      department:new FormControl('')
    })

    this.departmentService.findAll().subscribe(
      (data)=>{
        this.departmentList=data;
        console.log(this.departmentList)
      }
    )
  }

  compareByID(obj1: any, obj2: any) {
    return obj1 && obj2 && obj1.id == obj2.id
  }

  save() {
    this.accountService.save(this.accountForm.value).subscribe(
      ()=>{
        this.router.navigateByUrl("account")
      }
    )
  }
}
