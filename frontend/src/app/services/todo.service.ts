import { Injectable } from '@angular/core';
import {Todo} from "../models/todo.model";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
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
  constructor() {
    console.log('TodoService constructor');
  }

  getAllTodos():Array<Todo>
  {
    return this.todos;
  }
}
