import { EventEmitter, Injectable, Output } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { CookieService } from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  @Output() getStatus: EventEmitter<any> = new EventEmitter();
  constructor(private http: HttpClient,
              private cookies: CookieService) { }

  login(user: string, password: string): Observable<any> {
      const headers = new HttpHeaders()
      const body = JSON.stringify({})
      const params = new HttpParams()
        .set('user', user)
        .set('password', password)
      return this.http.post("http://localhost:8081/user/login", body, {
                            params: params
                            });
  }

  setToken(token: string) {
    this.cookies.set("token", token);
  }
  getToken() {
    return this.cookies.get("token");
  }
  setUser(user: string) {
    this.cookies.set("user", user);
  }
  getUser() {
    return this.cookies.get("user");
  }
  logout() {
    this.cookies.deleteAll();
    this.getStatus.emit("logout");
  }
}
