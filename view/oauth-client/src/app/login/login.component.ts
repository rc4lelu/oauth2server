import { Component } from '@angular/core';
import {AuthService} from "./auth.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  imports: [
    FormsModule
  ],
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private authService: AuthService) {}

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: response => {
        console.log(response)
        window.location = response.redirectUrl;

      },
      error : err => {
        console.log("======d===========d=========")
        console.log(err)
      },
      complete : () => {}

    });

  }
}
