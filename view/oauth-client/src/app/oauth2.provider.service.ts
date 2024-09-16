import { Injectable } from '@angular/core';
import {AuthConfig, OAuthService} from "angular-oauth2-oidc";

@Injectable({
  providedIn: 'root'
})
export class Oauth2ProviderService {

  private authConfig: AuthConfig = {
    issuer: 'http://localhost:8080',
    redirectUri: window.location.origin + '/callback',
    clientId: 'webapp',
    responseType: 'code',
    scope: 'openid',
    showDebugInformation: true,
  };

  constructor(private oauthService: OAuthService) {
    this.configureOAuth();
  }

  private configureOAuth() {
    this.oauthService.configure(this.authConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }
}
