import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  redirectUrl:string = '';
  loginForm = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]],
    password: ['', [Validators.required]]
  });
  constructor(private fb:FormBuilder,
              private router:Router,
              private route:ActivatedRoute,
              private authService:AuthService) {

  }
  ngOnInit(): void {
    console.log("isAuthenticated ",this.authService.isAuthenticated());
    if(this.authService.isAuthenticated())
    {
      this.router.navigate(['/home']);
    }
    this.route.queryParams
      .subscribe(params => {
          console.log(params);
          this.redirectUrl = params['redirectUrl'];
          console.log('Redirect Url ',this.redirectUrl); // popular
        }
      );
  }
  get username()
  {
    return this.loginForm.controls.username;
  }
  get password()
  {
    return this.loginForm.controls.password;
  }
  onSubmit()
  {
    console.log('Login ',this.loginForm.value);
    let loginData:any = this.loginForm.value;
    this.authService.login(loginData)
      .subscribe(data=>{
        console.log('Response ',data);
        this.loginOk(data);
      },error => {
        console.log('Login error ',error);
      });
  }
  private loginOk(response:any) {
    console.log("Response ", response);
    console.log("token ", response.token);
    localStorage.setItem("token", response.token);
    this.authService.setAuthentication(response.token);
    if(this.redirectUrl)
    {
      this.router.navigate([this.redirectUrl]);
    }
    else {
      this.router.navigate(['/home']);
    }

  }
}
