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

  onSubmit(): void {

      let userParam: string;
      let passParam: string;
      userParam = ''+this.checkoutForm.value.login;
      passParam = ''+this.checkoutForm.value.password;
      this.loginService.login(userParam, passParam).subscribe(
        data => {
          console.log(data);
          this.loginService.setToken(data.token);
          this.loginService.setUser(data.username)
          Swal.fire({
            icon: 'success',
            title: 'Inicio de sesión correcto',
            text: 'Bienvenido, ' + data.username,
            confirmButtonColor: '#50504f'
          });
          this.router.navigateByUrl('/');
          this.loginService.getStatus.emit("login");
        },
        error => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Verifica usuario y/o contraseña',
            confirmButtonColor: '#50504f'
          });
        });
  
      this.checkoutForm.reset();
  }

}
