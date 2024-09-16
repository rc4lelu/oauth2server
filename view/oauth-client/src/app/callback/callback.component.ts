import { Component } from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-callback',
  standalone: true,
  imports: [],
  templateUrl: './callback.component.html',
  styleUrl: './callback.component.scss'
})
export class CallbackComponent {

  constructor(private oauthService: OAuthService) {
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }
}
