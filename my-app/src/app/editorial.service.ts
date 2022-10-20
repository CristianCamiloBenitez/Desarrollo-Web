import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Editorial } from './editorial/editorial';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {

  constructor(private http: HttpClient) { }

  getEditorials(): Observable<Editorial[]> {
    return this.http.get<Editorial[]>("http://localhost:8002/editorial/all");
  }
}
