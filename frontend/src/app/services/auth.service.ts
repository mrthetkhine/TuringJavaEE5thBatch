import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "./Api";
import {LoginUser} from "../models/login-user.model";

const API  = BASE_URL+"/login";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient)
  {

  }
  login(data:LoginUser)
  {

  }
}
