import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-tab-page',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './tab-page.component.html',
  styleUrl: './tab-page.component.css'
})
export class TabPageComponent {
  active:boolean= false;
}
