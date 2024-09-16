import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient} from "@angular/common/http";
import {AuthConfig, OAuthService} from "angular-oauth2-oidc";

const authConfig: AuthConfig = {
  issuer: 'http://localhost:8080', // Serveur OAuth2
  redirectUri: window.location.origin + '/callback', // URI de redirection pour la deuxième application
  clientId: 'other-app', // Identifiant client de la deuxième application
  responseType: 'code', // Utilisation de "authorization_code" flow
  scope: 'openid',
  showDebugInformation: true,
};

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    OAuthService
  ]
};
