import { Component } from '@angular/core';
import {CustomTabComponent} from "../custom-tab/custom-tab.component";
import {TabPageComponent} from "../tab-page/tab-page.component";

@Component({
  selector: 'app-tab-demo',
  standalone: true,
  imports: [
    CustomTabComponent,
    TabPageComponent,
  ],
  templateUrl: './tab-demo.component.html',
  styleUrl: './tab-demo.component.css'
})
export class TabDemoComponent {
  headers = ['Tab1','Tab2','Tab3']
}
