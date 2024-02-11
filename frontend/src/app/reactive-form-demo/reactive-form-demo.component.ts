import { Component } from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-reactive-form-demo',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './reactive-form-demo.component.html',
  styleUrl: './reactive-form-demo.component.css'
})
export class ReactiveFormDemoComponent {
  constructor(private fb: FormBuilder) { }

  userForm = this.fb.group({
    firstName:['', [Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
    lastName: ['', [Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
    email : ['', [Validators.required,Validators.email]],
  });
  updateUser()
  {
    this.userForm.patchValue({
      firstName :"Update",
      lastName : "Lastnameu update",
      email:"Email update"
    })
  }
  get firstName()
  {
    return this.userForm.controls.firstName;
  }
  get lastName()
  {
    return this.userForm.controls.lastName;
  }
  get email()
  {
    return this.userForm.controls.email;
  }
  updateName()
  {
    this.userForm.controls.firstName.setValue('First name update');
  }
  onSubmit()
  {
    console.log('Form value ',this.userForm.value);
  }
}
