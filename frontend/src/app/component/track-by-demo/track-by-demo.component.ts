import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-track-by-demo',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './track-by-demo.component.html',
  styleUrl: './track-by-demo.component.css'
})
export class TrackByDemoComponent {
  items = ['One','Two','Three'];

  addItem()
  {
    this.items.push('New Item');
  }
}
