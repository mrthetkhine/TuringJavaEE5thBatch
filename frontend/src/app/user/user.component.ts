import {Component, Input, Output,EventEmitter} from '@angular/core';
import {User} from "../user.model";

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})

export class UserComponent {
  count = 0;

  @Input({required: true})
  user!:User;

  @Input({transform: upperCase})
  message ='';

  @Output()
  btnClick  = new EventEmitter<number>();

  @Input()
  set data(newValue: string) {
    this.internalValue = newValue;
  }
  get data()
  {
    return this.internalValue;
  }
  private internalValue = '';

  btnClickHandler()
  {
    this.count++;
    console.log('Count ',this.count);
    this.btnClick.emit(this.count);
  }
}
function upperCase(value:string|undefined)
{
  console.log('Uppercase ');
  return value?.toUpperCase()??'';
}
