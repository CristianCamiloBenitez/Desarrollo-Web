import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userIsAuth: boolean = false;
  username: string="";
  constructor(private loginService: LoginService) {
    loginService.getStatus.subscribe(name => this.checkAuth());
   }

  ngOnInit(): void {
    this.checkAuth();
  }

  checkAuth(): void {
    if(this.loginService.getToken()){
      this.userIsAuth = true;
      this.username = this.loginService.getUser();
    }
    else {
      this.userIsAuth = false;
      this.username = "";
    }
  }

  logout(): void {
    this.loginService.logout();
    Swal.fire({
      icon: 'success',
      title: 'Se cerro la sesión',
      confirmButtonColor: '#50504f'
    });
  }
}
