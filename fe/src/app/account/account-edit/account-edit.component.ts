import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AccountService} from "../../../service/account.service";
import {FormControl, FormGroup} from "@angular/forms";
import {DepartmentService} from "../../../service/department.service";

@Component({
  selector: 'app-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit {
  account:any;
  accountForm: FormGroup | any;
  roleList=["ROLE_ADMIN","ROLE_USER"]
  departmentList:any;
  constructor(
    private activatedRoute:ActivatedRoute,
    private accountService:AccountService,
    private departmentService:DepartmentService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.accountForm = new FormGroup({
      username: new FormControl(''),
      name: new FormControl(''),
      role:new FormControl(''),
      department:new FormControl('')
    })

    const username = String(this.activatedRoute.snapshot.paramMap.get('id'));

    this.accountService.findById(username).subscribe(
      (data)=>{
        this.account=data;
        this.accountForm.controls['username'].setValue(this.account.username);
        this.accountForm.controls['name'].setValue(this.account.name);
        this.accountForm.controls['role'].setValue(this.account.role);
        this.accountForm.controls['department'].setValue(this.account.department);

        this.departmentService.findAll().subscribe(
          (data)=>{
            this.departmentList=data;
            console.log(this.departmentList)
          }
        )
      }

    )
  }

  compareByID(obj1: any, obj2: any) {
    return obj1 && obj2 && obj1.id == obj2.id
  }

  resetPassword() {
  this.accountService.resetPassword(this.account.username).subscribe(
    ()=>{
      alert("Đã reset password 123456")
    }
  )
  }

  update() {
    this.accountService.update(this.account.username,this.accountForm.value).subscribe(
      (data)=>{
        this.router.navigateByUrl("/account")
      }
    )
  }
}
