import { Component } from '@angular/core';
import {InnerItemComponent} from "../inner-item/inner-item.component";
import {OuterContainerComponent} from "../outer-container/outer-container.component";

@Component({
  selector: 'app-view-container-demo',
  standalone: true,
  imports: [InnerItemComponent,OuterContainerComponent],
  templateUrl: './view-container-demo.component.html',
  styleUrl: './view-container-demo.component.css'
})
export class ViewContainerDemoComponent {

}
