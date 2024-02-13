import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Todo} from "../models/todo.model";

@Injectable({
  providedIn: 'root'
})
export class ReactiveTodoService {

  private _todoData:Array<Todo> = [];
  private _todos: BehaviorSubject<Array<Todo>> = new BehaviorSubject<Array<Todo>>([]);
  public readonly todos: Observable<Array<Todo>> = this._todos.asObservable();

  constructor(private http:HttpClient) {
    this.loadAllTodo();
  }
  loadAllTodo()
  {
    this.http.get<Todo[]>('https://jsonplaceholder.typicode.com/todos')
      .subscribe(todos=>{
        this._todoData = todos;
        this.emitChange();
      })
  }
  private emitChange() {
    this._todos.next(this._todoData);
  }
  deleteTodo(todo:Todo)
  {
    this._todoData = this._todoData.filter((item:Todo)=>item.id!=todo.id);
    this.emitChange();
  }
}
