import { Component, OnInit } from '@angular/core';
import {VanbandenService} from "../../../service/vanbanden.service";
import {Router} from "@angular/router";

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

  constructor(
    private vanbandenService:VanbandenService,
    private router:Router
  ) { }

  ngOnInit(): void {
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
    // @ts-ignore
    formData.append("file", this.file)
    this.vanbandenService.save(formData).subscribe(
      ()=>{
        this.router.navigateByUrl("")
      }
    )
  }
}
