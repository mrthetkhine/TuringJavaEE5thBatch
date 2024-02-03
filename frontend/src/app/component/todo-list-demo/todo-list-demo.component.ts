import { Component } from '@angular/core';
import {Todo} from "../../models/todo.model";
import {TodoComponent} from "../todo/todo.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-todo-list-demo',
  standalone: true,
  imports: [
    TodoComponent,
    CommonModule,
  ],
  templateUrl: './todo-list-demo.component.html',
  styleUrl: './todo-list-demo.component.css'
})
export class TodoListDemoComponent {
  todos:Array<Todo> = [
    {
      id:1,
      title:'Task 1'
    },
    {
      id:2,
      title:'Task 2'
    },
    {
      id:3,
      title:'Task 3'
    },
    {
      id:4,
      title:'Task 4'
    }
  ]

  deleteEvent(todo:Todo)
  {
    console.log('Delete todo ',todo);
    this.todos = this.todos.filter(item=>item.id!= todo.id);
  }
}
