import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Todo} from "../../models/todo.model";

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  @Input()
  todo!:Todo;

  @Output()
  onDelete = new EventEmitter<Todo>();

  ngOnChanges()
  {
    console.log('OnChange');
  }
  ngAfterContentChecked()
  {
    console.log('Content checked');
  }
  deleteBtnHandler(event:MouseEvent)
  {
    console.log('Todo.deleteBtnHandler ',event);
    event.preventDefault();
    this.onDelete.emit(this.todo);
  }
}
