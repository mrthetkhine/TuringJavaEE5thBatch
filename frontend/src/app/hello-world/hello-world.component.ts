import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-hello-world',
  standalone: true,
  imports: [],
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css'
})
export class HelloWorldComponent implements OnInit{
  currentDate;
  imageUrl='https://images.unsplash.com/photo-1706602954628-00f1973a3676?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D';
  constructor() {
    console.log('Constructor');
    this.currentDate = new Date();

  }
  ngOnChanges()
  {
    console.log('ngOnChange');
  }
  ngDoCheck()
  {
    console.log('HelloWorld DoCheck');
  }
  ngOnInit() {
   console.log('OnInit');
  }
  /*
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
  }*/
  btnClickHandler($event:Event)
  {
    console.log('Btn click');
  }
  changeDate()
  {
    this.currentDate =new Date();
  }
}
