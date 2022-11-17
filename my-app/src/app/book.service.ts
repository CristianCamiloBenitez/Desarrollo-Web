import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Book } from './books/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  searchResults = new BehaviorSubject<Array<Book>>([]);
  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>("http://localhost:8080/books/all");
  }

  searchByName(Name: string){
    this.http.get<Book[]>("http://localhost:8080/books/"+Name).subscribe(
      results => this.searchResults.next(results)
    );
  }

  searchByEditorialId(id: number){
    this.http.get<Book[]>("http://localHost:8080/books/editorial/" + id).subscribe(
        results => this.searchResults.next(results)
       );
}

onResults(){
    return this.searchResults.asObservable();
}
}
