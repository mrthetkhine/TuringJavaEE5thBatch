import { Component } from '@angular/core';
import {NgClass, NgStyle} from "@angular/common";

@Component({
  selector: 'app-directive-demo',
  standalone: true,
  imports: [
    NgClass,
    NgStyle,
  ],
  templateUrl: './directive-demo.component.html',
  styleUrl: './directive-demo.component.css'
})
export class DirectiveDemoComponent {
  currentStyles: object = {};

  canSave = true;
  isUnchanged = false;
  isSpecial = false;

  setCurrentStyles() {
    // CSS styles: set per current state of component properties
    this.currentStyles = {
      'font-style': this.canSave ? 'italic' : 'normal',
      'font-weight': !this.isUnchanged ? 'bold' : 'normal',
      'font-size': this.isSpecial ? '24px' : '12px',
    };
  }
}
