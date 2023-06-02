import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import  { Validation } from '../shared/validation';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(7)]],
      email: ['', [Validators.required, Validators.pattern(/^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/)]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
    }, { validator: Validation.passwordMatchValidator });
  }

  onSubmit() {
    if (this.form.valid) {
      // Form submission logic
    }
  }

  get f() {
    return this.form.controls;
  }
}
