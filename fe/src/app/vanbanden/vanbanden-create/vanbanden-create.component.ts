import { Component, OnInit } from '@angular/core';
import {VanbandenService} from "../../../service/vanbanden.service";
import {Router} from "@angular/router";
import {DepartmentService} from "../../../service/department.service";
import {AccountService} from "../../../service/account.service";

@Component({
  selector: 'app-vanbanden-create',
  templateUrl: './vanbanden-create.component.html',
  styleUrls: ['./vanbanden-create.component.css']
})
export class VanbandenCreateComponent implements OnInit {
  ngayPhatHanh:any;
  soVanBanDen:any;
  tenVanBanDen:any
  noiPhatHanh: any;
  file: File | undefined
  departmentList: any;
  EmployeeList:any;
  account: any;

  constructor(
    private vanbandenService:VanbandenService,
    private departmentService:DepartmentService,
    private accountService:AccountService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.departmentService.findAll().subscribe(
      (data)=>{
        this.departmentList=data;
      }
    )
  }

  onSelected(event: any) {
    this.file = event.target.files[0];
  }

  upload() {
    var formData = new FormData()
    formData.append("ngayPhatHanh", this.ngayPhatHanh)
    formData.append("soVanBanDen", this.soVanBanDen)
    formData.append("tenVanBanDen", this.tenVanBanDen)
    formData.append("noiPhatHanh", this.noiPhatHanh)
    formData.append("account", this.account)
    // @ts-ignore
    formData.append("file", this.file)
    this.vanbandenService.save(formData).subscribe(
      ()=>{
        this.router.navigateByUrl("/vanbanden")
      }
    )
  }

  loadEmployee(event:any) {
    let departmentId=event.target.value
    this.accountService.findAccountsByDepartment_Id(departmentId).subscribe(
      (data)=>{
        console.log(data);
        this.EmployeeList=data;
      }
    )
  }

  Test() {
    console.log(this.account)
  }
}
