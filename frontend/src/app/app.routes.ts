import {ResolveFn, Routes} from '@angular/router';
import {FirstPageComponent} from "./pages/first-page/first-page.component";
import {SecondPageComponent} from "./pages/second-page/second-page.component";
import {NotFoundPageComponent} from "./pages/not-found-page/not-found-page.component";
import {ChildAComponent} from "./pages/child-a/child-a.component";
import {ChildBComponent} from "./pages/child-b/child-b.component";
import {TodoListComponent} from "./pages/todo-list/todo-list.component";
import {HomeComponent} from "./pages/home/home.component";
import {authRouteGuardGuard} from "./auth-route-guard.guard";
const resolvedChildATitle: ResolveFn<string> = () => Promise.resolve('Title of a');
export const routes: Routes = [
  { path: 'first-page',
    component: FirstPageComponent,
    children:[
      {
        path: 'child-a', // child route path
        title: resolvedChildATitle,
        component: ChildAComponent, // child route component that the router renders
      },
      {
        path: 'child-b',
        component: ChildBComponent, // another child route component that the router renders
      },
    ]
  },
  { path: 'second-page', component: SecondPageComponent },
  { path: 'home', component: HomeComponent,
    canActivate: [authRouteGuardGuard],},
  { path: 'todos/:id', component: TodoListComponent },
  { path: '',   redirectTo: '/first-page', pathMatch: 'full' },
  { path: '**', component: NotFoundPageComponent },
];

