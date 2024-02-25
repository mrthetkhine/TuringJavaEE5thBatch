import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {AuthService} from "./services/auth.service";

export const authRouteGuardGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const authService = inject(AuthService);
  console.log('Route guard ',route.url[0].path);
  if(authService.isAuthenticated())
  {
    return true;
  }
  else
  {
    router.navigate(['login'],
      { queryParams: { redirectUrl: route.url[0].path} });
    return false;
  }
};
