import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoListDemoComponent } from './todo-list-demo.component';

describe('TodoListDemoComponent', () => {
  let component: TodoListDemoComponent;
  let fixture: ComponentFixture<TodoListDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TodoListDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TodoListDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
