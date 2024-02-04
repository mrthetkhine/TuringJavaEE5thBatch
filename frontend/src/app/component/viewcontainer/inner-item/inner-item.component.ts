import {Component, ViewContainerRef} from '@angular/core';
import {LeaftContentComponent} from "../leaft-content/leaft-content.component";
import {OuterContainerComponent} from "../outer-container/outer-container.component";

@Component({
  selector: 'app-inner-item',
  standalone: true,
  imports: [
    LeaftContentComponent,
    OuterContainerComponent
  ],
  templateUrl: './inner-item.component.html',
  styleUrl: './inner-item.component.css'
})
export class InnerItemComponent {
  constructor(private viewContainer: ViewContainerRef) {}
  loadContent() {
    this.viewContainer.createComponent(LeaftContentComponent);
  }
}
