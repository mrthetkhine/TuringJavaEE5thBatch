import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {ListDemoComponent} from "./list-demo/list-demo.component";
import {CommonModule} from "@angular/common";
import {ImageDemoComponent} from "./image-demo/image-demo.component";
import {UserComponent} from "./user/user.component";
import {User} from "./user.model";
import {TodoListDemoComponent} from "./component/todo-list-demo/todo-list-demo.component";
import {BorderComponent} from "./component/border/border.component";
import {HostDemoComponent} from "./component/host-demo/host-demo.component";
import {ViewQueryDemoComponent} from "./component/view-query-demo/view-query-demo.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HelloWorldComponent,
    ListDemoComponent,
    ImageDemoComponent,
    UserComponent,
    TodoListDemoComponent,
    BorderComponent,
    HostDemoComponent,
    ViewQueryDemoComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forntend';
  user:User = {
    name : 'Tk',
    email:'somewhere@gmail.com'
  }

  clickHandler(count:number)
  {
    console.log("Count in parent ",count);
  }
}
