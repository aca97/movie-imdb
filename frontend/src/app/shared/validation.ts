import { AbstractControl } from '@angular/forms';

export class Validation {
  static passwordMatchValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
  
    if (password !== confirmPassword) {
      return { matching: true };
    }
  
    return null;
  }
}
