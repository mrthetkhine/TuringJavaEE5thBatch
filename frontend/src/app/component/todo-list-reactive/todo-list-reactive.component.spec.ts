import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoListReactiveComponent } from './todo-list-reactive.component';

describe('TodoListReactiveComponent', () => {
  let component: TodoListReactiveComponent;
  let fixture: ComponentFixture<TodoListReactiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TodoListReactiveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TodoListReactiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
