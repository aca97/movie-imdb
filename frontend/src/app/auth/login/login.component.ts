import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  hide = true;
  model: any = {};

  loginForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          // Validators.minLength(6),
          // Validators.pattern(
          //   '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])'
          // ),
        ],
      ],
    });
  }

  onSubmit() {
    const val = this.loginForm.value;

    this.authenticationService
    .login(val.email, val.password)
    .subscribe(
      () => {
        console.log("User is logged in");
        this.router.navigateByUrl('/');
    }
     
    );
  }

  getEmailErrorMessage() {
    if (this.loginForm.get('email')?.hasError('required')) {
      return 'You must enter a value';
    }

    return this.loginForm.get('email')?.hasError('email')
      ? 'Not a valid email'
      : '';
  }

  getPasswordErrorMessage() {
    const passwordControl = this.loginForm.get('password');

    if (passwordControl?.hasError('required')) {
      return 'Password is required';
    }

    if (passwordControl?.hasError('minlength')) {
      return 'Password must be at least 6 characters long';
    }

    if (passwordControl?.hasError('pattern')) {
      return 'Password must contain at least one lowercase letter, one uppercase letter, one number, and one symbol';
    }

    return '';
  }
}
