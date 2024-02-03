import {Component, HostListener} from '@angular/core';

@Component({
  selector: 'app-host-demo',
  standalone: true,
  imports: [],
  templateUrl: './host-demo.component.html',
  styleUrl: './host-demo.component.css',
  host: {
    'role': 'slider',
    '[attr.aria-valuenow]': 'value',
    '[tabIndex]': 'disabled ? -1 : 0',
    '(click)': 'updateValue($event)',
  },
})
export class HostDemoComponent {
  value: number = 0;
  disabled: boolean = false;
  updateValue(event: MouseEvent)
  {
    console.log('Click ');
    this.value++;
  }
  @HostListener('keydown', ['$event'])
  keyDown(event: KeyboardEvent) {
    console.log('Keydown ',event);
  }
}
