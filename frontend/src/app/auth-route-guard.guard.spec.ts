import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { authRouteGuardGuard } from './auth-route-guard.guard';

describe('authRouteGuardGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => authRouteGuardGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
