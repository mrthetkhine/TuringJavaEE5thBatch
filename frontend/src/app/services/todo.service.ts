import { Injectable } from '@angular/core';
import {Todo} from "../models/todo.model";
import {TodoComponent} from "../component/todo/todo.component";
import {CommonModule} from "@angular/common";
import {HttpClient} from "@angular/common/http";
import {Observable, Observer} from "rxjs";

@Injectable({
  providedIn: 'root',
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
  constructor(private httpClient:HttpClient) {
    console.log('TodoService constructor');
    //this.loadAllTodo();

  }
  loadAllTodo():Observable<Todo[]>
  {
    return this.httpClient.get<Todo[]>('https://jsonplaceholder.typicode.com/todos');
      /*
      .subscribe(data=>{
        console.log('Todo ',data);
        this.todos = data;
        return this.todos;
      });

       */
  }
  getAllTodos():Array<Todo>
  {
    return this.todos;
  }
}
