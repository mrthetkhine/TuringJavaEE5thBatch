import { TestBed } from '@angular/core/testing';

import { ReactiveTodoService } from './reactive-todo.service';

describe('ReactiveTodoService', () => {
  let service: ReactiveTodoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReactiveTodoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
