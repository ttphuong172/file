import { Component, OnInit } from '@angular/core';
import {AppService} from "../../../service/app.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  files:any;
  constructor(
    private appService:AppService
  ) { }

  ngOnInit(): void {
    this.appService.findAll().subscribe(
      (data)=>{
        console.log(data)
        this.files=data
      }
    )
  }

}
