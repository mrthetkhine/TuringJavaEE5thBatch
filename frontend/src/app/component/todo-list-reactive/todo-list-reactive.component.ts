import {ChangeDetectorRef, Component, NgZone} from '@angular/core';
import {Observable} from "rxjs";
import {Todo} from "../../models/todo.model";
import {TodoService} from "../../services/todo.service";
import {CommonModule} from "@angular/common";
import {ReactiveTodoService} from "../../services/reactive-todo.service";

@Component({
  selector: 'app-todo-list-reactive',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './todo-list-reactive.component.html',
  styleUrl: './todo-list-reactive.component.css'
})
export class TodoListReactiveComponent {
  todos:Observable<Array<Todo>> = new Observable<Array<Todo>>();
  constructor(private todoService:ReactiveTodoService
              ) {

    console.log('TodoList constructor');
  }
  ngOnInit()
  {
    this.todos = this.todoService.todos;
  }
  deleteTodo(todo:Todo)
  {
    console.log('Delete todo ',todo);
    this.todoService.deleteTodo(todo);
  }
}
