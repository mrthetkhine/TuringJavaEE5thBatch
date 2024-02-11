import { Component } from '@angular/core';
import {Todo} from "../../models/todo.model";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-template-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './template-form.component.html',
  styleUrl: './template-form.component.css'
})
export class TemplateFormComponent {
  model = new Todo(1,'Task 1');
  submitted = false;
  onSubmit()
  {
    //this.submitted = true;
    console.log('Model ',this.model);
  }
  show()
  {
    console.log('Model ',this.model);
  }
  updateModel()
  {
    this.model.title ='update '+this.model.title;
  }


}
