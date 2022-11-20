import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service'
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    checkoutForm = this.formBuilder.group({
      login: '',
      password: '',
    });

  constructor(private formBuilder: FormBuilder,
              private loginService: LoginService,
              public router: Router) { }

  ngOnInit(): void {
  }

  /** login con username y password 
   * 
   */
  onSubmit(): void {

      let userParam: string;
      let passParam: string;
      userParam = ''+this.checkoutForm.value.login;
      passParam = ''+this.checkoutForm.value.password;
      console.log('FormValue:', this.checkoutForm.value);
      console.log('Login:', this.checkoutForm.value.login);
      console.log('Password:', this.checkoutForm.value.password);
      this.loginService.login(userParam, passParam).subscribe({
                                      next: (data) => {
                                                        console.log(data);
                                                        this.loginService.setToken(data.token);
                                                        Swal.fire({
                                                          icon: 'success',
                                                          title: 'Inicio de sesión correcto',
                                                          text: 'Bienvenido',
                                                          confirmButtonColor: '#50504f'
                                                        });
                                                        this.router.navigateByUrl('/'); 
                                                      },
                                                      error: (err) =>{
                                                        Swal.fire({
                                                          icon: 'error',
                                                          title: 'Error',
                                                          text: 'Usuario o contraseña erronea',
                                                          confirmButtonColor: '#50504f'
                                                        });
                                                      },
      });
      this.checkoutForm.reset();
  }
}