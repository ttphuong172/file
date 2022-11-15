import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private apiURL = environment.apiURL;
  constructor(
    private httpClient:HttpClient
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
}
