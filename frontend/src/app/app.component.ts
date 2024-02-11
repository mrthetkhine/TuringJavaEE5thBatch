import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {ListDemoComponent} from "./list-demo/list-demo.component";
import {CommonModule} from "@angular/common";
import {ImageDemoComponent} from "./image-demo/image-demo.component";
import {UserComponent} from "./user/user.component";
import {User} from "./user.model";
import {TodoListDemoComponent} from "./component/todo-list-demo/todo-list-demo.component";
import {BorderComponent} from "./component/border/border.component";
import {HostDemoComponent} from "./component/host-demo/host-demo.component";
import {ViewQueryDemoComponent} from "./component/view-query-demo/view-query-demo.component";
import {CustomTabComponent} from "./component/tab/custom-tab/custom-tab.component";
import {TabPageComponent} from "./component/tab/tab-page/tab-page.component";
import {TabDemoComponent} from "./component/tab/tab-demo/tab-demo.component";
import {ViewChildDemoComponent} from "./component/view-child-demo/view-child-demo.component";
import {ProfilePhotoComponent} from "./component/profile-photo/profile-photo.component";
import {DynamicRenderDemoComponent} from "./component/dynamicrender/dynamic-render-demo/dynamic-render-demo.component";
import {ViewContainerDemoComponent} from "./component/viewcontainer/view-container-demo/view-container-demo.component";
import {SizerComponent} from "./component/twowaybinding/sizer/sizer.component";
import {DirectiveDemoComponent} from "./component/directive-demo/directive-demo.component";
import {TrackByDemoComponent} from "./component/track-by-demo/track-by-demo.component";
import {SignalDemoComponent} from "./component/signal-demo/signal-demo.component";
import {FirstPageComponent} from "./pages/first-page/first-page.component";
import {SecondPageComponent} from "./pages/second-page/second-page.component";
import {NotFoundPageComponent} from "./pages/not-found-page/not-found-page.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ReactiveFormDemoComponent} from "./reactive-form-demo/reactive-form-demo.component";
import {DynamicFormComponent} from "./component/dynamic-form/dynamic-form.component";
import {TemplateFormComponent} from "./component/template-form/template-form.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterLink,
    RouterLinkActive,
    HelloWorldComponent,
    ListDemoComponent,
    ImageDemoComponent,
    UserComponent,
    TodoListDemoComponent,
    BorderComponent,
    HostDemoComponent,
    ViewQueryDemoComponent,
    TabDemoComponent,
    ViewChildDemoComponent,
    ProfilePhotoComponent,
    DynamicRenderDemoComponent,
    ViewContainerDemoComponent,
    SizerComponent,
    DirectiveDemoComponent,
    TrackByDemoComponent,
    SignalDemoComponent,
    FirstPageComponent,
    SecondPageComponent,
    NotFoundPageComponent,
    ReactiveFormDemoComponent,
    DynamicFormComponent,
    TemplateFormComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forntend';
  fontSizePx = 10;
  user:User = {
    name : 'Tk',
    email:'somewhere@gmail.com'
  }

  clickHandler(count:number)
  {
    console.log("Count in parent ",count);
  }
}
