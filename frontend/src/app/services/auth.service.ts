import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "./Api";
import {LoginUser} from "../models/login-user.model";
import {Router} from "@angular/router";

const API  = BASE_URL;
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authenticated = false;
  token:string = '';
  constructor(private http:HttpClient,
              private router: Router)
  {

  }
  loadToken()
  {
    let token = localStorage.getItem("token");
    if(token)
    {
      this.setAuthentication(token);
    }
  }
  isAuthenticated()
  {
    return this.authenticated;
  }
  setAuthentication(token:string)
  {
    this.token = token;
    this.authenticated = true;
  }
  login(data:LoginUser)
  {
    return this.http.post(API+'/login',data);
  }
  getToken()
  {
    return this.token;
  }
  logout()
  {
    localStorage.removeItem("token");
    this.token = "";
    this.authenticated = false;
    this.router.navigate(["/login"]);
  }
}
