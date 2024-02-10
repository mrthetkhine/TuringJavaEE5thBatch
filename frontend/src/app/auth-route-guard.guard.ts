import { CanActivateFn } from '@angular/router';

export const authRouteGuardGuard: CanActivateFn = (route, state) => {
  console.log('Route guard');
  return true;
};
