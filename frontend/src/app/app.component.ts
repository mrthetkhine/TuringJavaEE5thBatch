import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {ListDemoComponent} from "./list-demo/list-demo.component";
import {CommonModule} from "@angular/common";
import {ImageDemoComponent} from "./image-demo/image-demo.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HelloWorldComponent,
    ListDemoComponent,
    ImageDemoComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forntend';
}
