import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../environments/environment";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private apiURL = environment.apiURL;
  constructor(
    private httpClient:HttpClient,
    private authService:AuthService
  ) { }
  findAll(){
    return  this.httpClient.get(this.apiURL+ '/api/accounts')
  }
  findById(username:any){
    return this.httpClient.get(this.apiURL+ '/api/accounts/'+ username)
  }
  resetPassword(username:any){
    return this.httpClient.get(this.apiURL+ '/api/accounts/reset/'+ username)
  }
  update(username: any, account:any){
    return this.httpClient.put(this.apiURL+ '/api/accounts/'+ username,account)
  }
  save(account:any){
    return this.httpClient.post(this.apiURL+ '/api/accounts',account)
  }
  findAccountsByDepartment_Id(id:any){
    let httpOptions = {
      headers: new HttpHeaders({
        'Authorization': "Bearer " + this.authService.getToken()
      })
    }
    return this.httpClient.get(this.apiURL + '/api/accounts/department/' + id, httpOptions);
  }

}
