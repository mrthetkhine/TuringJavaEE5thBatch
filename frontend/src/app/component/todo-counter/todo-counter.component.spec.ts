import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoCounterComponent } from './todo-counter.component';

describe('TodoCounterComponent', () => {
  let component: TodoCounterComponent;
  let fixture: ComponentFixture<TodoCounterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TodoCounterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TodoCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
