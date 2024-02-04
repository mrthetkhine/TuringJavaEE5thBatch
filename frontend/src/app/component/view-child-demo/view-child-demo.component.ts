import {Component, ElementRef, ViewChild} from '@angular/core';

@Component({
  selector: 'app-view-child-demo',
  standalone: true,
  imports: [],
  templateUrl: './view-child-demo.component.html',
  styleUrl: './view-child-demo.component.css'
})
export class ViewChildDemoComponent {
  disabled =false;
  @ViewChild('btnCancel') btnCancel!: ElementRef<HTMLButtonElement>;

  @ViewChild('btnOk') btnOk!: ElementRef<HTMLButtonElement>;

  showAll()
  {
    console.log('Cancel button ',this.btnCancel);
    console.log('Ok Button  ',this.btnOk);
    this.disabled = !this.disabled;
  }
}
