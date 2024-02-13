import {ChangeDetectionStrategy, ChangeDetectorRef, Component, NgZone} from '@angular/core';
import {Todo} from "../../models/todo.model";
import {TodoComponent} from "../todo/todo.component";
import {CommonModule} from "@angular/common";
import {TodoService} from "../../services/todo.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-todo-list-demo',
  standalone: true,
  imports: [
    TodoComponent,
    CommonModule,
  ],
  templateUrl: './todo-list-demo.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrl: './todo-list-demo.component.css',
  providers:[TodoService]
})
export class TodoListDemoComponent {
  id = 5;

  todos :Array<Todo> =[];
  //todos:Observable<Array<Todo>>;
  constructor(private todoService:TodoService,
              private ref: ChangeDetectorRef,
              public zone: NgZone) {

    console.log('TodoList constructor');
  }
  manualChangeDetect()
  {
    this.todoService.loadAllTodo()
      .subscribe(data=>{
        console.log('Data ',data);
        this.todos = data;
        this.ref.markForCheck();
        //console.log('Todos ',this.todos);
      });
  }
  ngOnInit()
  {
    this.manualChangeDetect();
    //this.todos = this.todoService.loadAllTodo();
  }
  deleteEvent(todo:Todo)
  {
    console.log('Delete todo ',todo);
    this.todos = this.todos.filter(item=>item.id!= todo.id);
  }
  addTodo()
  {
    this.todos.push ({
      id: this.id,
      title :'New Item '+(this.id++)
    });

  }
  trackByItems(index: number, item: Todo): number {
    return item.id;
  }
  reset()
  {
    this.todos = this.todoService.getAllTodos();
  }
}
