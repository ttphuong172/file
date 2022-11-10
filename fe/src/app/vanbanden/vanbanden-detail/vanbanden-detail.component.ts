import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VanbandenService} from "../../../service/vanbanden.service";

@Component({
  selector: 'app-vanbanden-detail',
  templateUrl: './vanbanden-detail.component.html',
  styleUrls: ['./vanbanden-detail.component.css']
})
export class VanbandenDetailComponent implements OnInit {
  vanBanDen:any;
  constructor(
    private activatedRoute:ActivatedRoute,
    private vanbandenService:VanbandenService
  ) { }

  ngOnInit(): void {
    const id = String(this.activatedRoute.snapshot.paramMap.get('id'));
    this.vanbandenService.findById(id).subscribe(
      (data)=>{
        this.vanBanDen=data;
      }
    )
  }

}
