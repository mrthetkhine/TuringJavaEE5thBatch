import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Todo} from "../../models/todo.model";
import {ActivatedRoute, Router, RouterLink, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive,
  ],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  @Input()
  todo!:Todo;

  @Output()
  onDelete = new EventEmitter<Todo>();
  constructor(
    private router:Router,
    private route: ActivatedRoute) {}
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
  gotoTodoDetails()
  {
    this.router.navigate([`todos/${this.todo.id}`]);
  }
}
