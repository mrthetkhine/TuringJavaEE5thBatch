import { Component } from '@angular/core';
import {FormArray, FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-dynamic-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './dynamic-form.component.html',
  styleUrl: './dynamic-form.component.css'
})
export class DynamicFormComponent {
  dynamicForm =  this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],

    aliases: this.fb.array([
      this.fb.control('')
    ])
  });
  constructor(public fb:FormBuilder) {
  }
  get aliases() {
    return this.dynamicForm.get('aliases') as FormArray;
  }
  addAlias() {
    this.aliases.push(this.fb.control(''));
  }
  onSubmit()
  {
    //console.log(this.dynamicForm.controls.firstName.toUpperCase());
    console.log('Value ',this.dynamicForm.value);
  }
}
