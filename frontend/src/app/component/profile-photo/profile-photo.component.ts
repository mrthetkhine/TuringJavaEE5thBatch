import {afterRender, Component, ElementRef} from '@angular/core';

@Component({
  selector: 'app-profile-photo',
  standalone: true,
  imports: [],
  templateUrl: './profile-photo.component.html',
  styleUrl: './profile-photo.component.css'
})
export class ProfilePhotoComponent {
  constructor(elementRef: ElementRef) {
    console.log(elementRef.nativeElement);
    afterRender(() => {
      // Focus the first input element in this component.
      elementRef.nativeElement.querySelector('input')?.focus();
    });
  }
}
