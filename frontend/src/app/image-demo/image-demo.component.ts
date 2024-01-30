import { Component } from '@angular/core';

@Component({
  selector: 'app-image-demo',
  standalone: true,
  imports: [],
  templateUrl: './image-demo.component.html',
  styleUrl: './image-demo.component.css'
})
export class ImageDemoComponent {
  imageUrl='https://images.unsplash.com/photo-1706602954628-00f1973a3676?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D';
  isDisable = false;
  themClass= '';
  btnChangeHandler()
  {
    this.imageUrl = 'https://images.unsplash.com/photo-1704989253528-8858dad13920?q=80&w=2862&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D';
    this.isDisable =true;
  }
  btnChangeThemeHandler()
  {
    this.themClass = 'theme'
  }
}
