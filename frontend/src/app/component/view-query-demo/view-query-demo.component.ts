import {Component, ViewChild} from '@angular/core';
import {HelloWorldComponent} from "../../hello-world/hello-world.component";
import {ImageDemoComponent} from "../../image-demo/image-demo.component";

@Component({
  selector: 'app-view-query-demo',
  standalone: true,
  imports: [HelloWorldComponent,ImageDemoComponent],
  templateUrl: './view-query-demo.component.html',
  styleUrl: './view-query-demo.component.css'
})
export class ViewQueryDemoComponent {
  @ViewChild(HelloWorldComponent) helloWorld!: HelloWorldComponent;

  showHelloWorld()
  {
    console.log('HelloWorld ',this.helloWorld);
    this.helloWorld.changeDate();
  }
}
