import { Component, OnInit } from '@angular/core';
import {VanbandenService} from "../../../service/vanbanden.service";

@Component({
  selector: 'app-vanbanden-list',
  templateUrl: './vanbanden-list.component.html',
  styleUrls: ['./vanbanden-list.component.css']
})
export class VanbandenListComponent implements OnInit {
  vanBanDens:any
  constructor(
    private vanbandenService:VanbandenService
  ) { }

  ngOnInit(): void {
    this.vanbandenService.findAll().subscribe(
      (data)=>{
        console.log(data);
        this.vanBanDens=data;
      }
    )
  }

}
