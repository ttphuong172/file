import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class VanbandenService {
  private apiURL = environment.apiURL;

  constructor(
    private httpClient: HttpClient
  ) {
  }

  findAll() {
    return this.httpClient.get(this.apiURL + '/api/vanbandens/');
  }

  save(formData: any) {
    return this.httpClient.post(this.apiURL + '/api/vanbandens/upload', formData);
  }
  findById(id:any){
    return this.httpClient.get(this.apiURL + '/api/vanbandens/'+ id);
  }
}
