import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
  file: File | undefined
  formCV = new FormGroup({
    id:new FormControl('')
  })

  value: any;
  name: any;
  constructor(
    private httpClient:HttpClient
  ) { }

  ngOnInit(): void {
  }

  onSelected(event: any) {
    this.file = event.target.files[0];
    console.log(event.target.files[0]);
  }

  upload() {
    var formData = new FormData()
    formData.append("id",this.value)
    formData.append("name",this.name)
    // @ts-ignore
    formData.append("file", this.file)

    this.httpClient.post('http://localhost:8080/api/files/upload',formData).subscribe()
  }
}
