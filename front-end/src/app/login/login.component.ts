import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  signUp: boolean;
  logIn: boolean;

  constructor() {
    this.logIn = true;
    this.signUp = false;
  }

  signupForm() {
    this.signUp = true;
    this.logIn = false;
  }

  loginForm() {
    this.signUp = false;
    this.logIn = true;
  }

  ngOnInit() {
  }

}
