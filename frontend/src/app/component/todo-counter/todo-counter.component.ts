import { Component } from '@angular/core';
import {ReactiveTodoService} from "../../services/reactive-todo.service";

@Component({
  selector: 'app-todo-counter',
  standalone: true,
  imports: [],
  templateUrl: './todo-counter.component.html',
  styleUrl: './todo-counter.component.css'
})
export class TodoCounterComponent {
  count =0;
  constructor(private todoService:ReactiveTodoService) {
  }
  ngOnInit()
  {
    this.todoService.todos.subscribe(data=>{
      this.count =data.length;
    });
  }
}
