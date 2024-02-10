import { Component } from '@angular/core';
import {TodoListDemoComponent} from "../../component/todo-list-demo/todo-list-demo.component";
import {ReactiveFormDemoComponent} from "../../reactive-form-demo/reactive-form-demo.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    TodoListDemoComponent,
    ReactiveFormDemoComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
