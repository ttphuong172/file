import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  public setToken(jwtToken: string) {
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken() {
    return localStorage.getItem('jwtToken');
  }

  public setUsername(username: string) {
    localStorage.setItem('username', username);
  }

  public getUsername() {
    return localStorage.getItem('username');
  }

  public setRole(role: string) {
    localStorage.setItem("role", role)
  }

  public getRole() {
    return localStorage.getItem('role')
  }

}
