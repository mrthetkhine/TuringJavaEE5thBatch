import { Component } from '@angular/core';
import {AdminComponent} from "../admin/admin.component";
import {UserComponent} from "../user/user.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-dynamic-render-demo',
  standalone: true,
  imports: [
    AdminComponent,
    UserComponent,
    CommonModule,
  ],
  templateUrl: './dynamic-render-demo.component.html',
  styleUrl: './dynamic-render-demo.component.css'
})
export class DynamicRenderDemoComponent {
  isAdmin = false;

  toggle()
  {
    this.isAdmin = !this.isAdmin;
  }
  getBioComponent()
  {
    return this.isAdmin ? AdminComponent : UserComponent;
  }
}
