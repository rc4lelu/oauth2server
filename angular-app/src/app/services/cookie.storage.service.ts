import { Injectable } from '@angular/core';
import {OAuthStorage} from "angular-oauth2-oidc";

@Injectable({
  providedIn: 'root'
})
export class CookieStorageService  implements OAuthStorage{

  // Méthode pour lire un cookie
  getItem(key: string): string | null {
    const name = key + '=';
    const decodedCookie = decodeURIComponent(document.cookie);
    const ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return null;
  }

  // Méthode pour écrire un cookie
  setItem(key: string, value: string): void {
    const expires = new Date();
    expires.setTime(expires.getTime() + (60 * 60 * 1000)); // Cookie valable 1 heure
    document.cookie = key + '=' + value + ';expires=' + expires.toUTCString() + ';path=/';
  }

  // Méthode pour supprimer un cookie
  removeItem(key: string): void {
    document.cookie = key + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;path=/';
  }
}
