import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-list-demo',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './list-demo.component.html',
  styleUrl: './list-demo.component.css'
})
export class ListDemoComponent {
  items;
  flag = true;
  customerInput:any;

  human = {
    name : 'TK',
    age : 39
  }
  constructor() {
    this.items =['Apple','Orange','Banana'];
  }
  ngOnChanges()
  {
    console.log('ngOnChange');
  }
  ngDoCheck()
  {
    console.log('DoCheck');
  }
  ngOnInit() {
    console.log('OnInit');
  }
  ngAfterContentInit()
  {
    console.log('ngAfterContentInit');
  }
  ngAfterContentChecked()
  {
    console.log('ngAfterContentChecked');
  }
  ngAfterViewInit()
  {
    console.log('ngAfterViewInit');
  }
  ngAfterViewChecked()
  {
    console.log('ngAfterViewChecked');
  }
  ngOnDestroy()
  {
    console.log('ngOnDestroy');
  }
  btnToggleHandler()
  {
    this.flag = !this.flag;
  }
}
