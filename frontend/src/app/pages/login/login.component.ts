import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";

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
  loginForm = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]],
    password: ['', [Validators.required]]
  });
  constructor(private fb:FormBuilder) {

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
  }

}
