import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from '../book.service';
import { Editorial } from '../editorial/editorial';
import { EditorialService } from '../editorial.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];
  editoriales: Editorial[] = [];
  constructor(private booksService: BookService, private editorialService: EditorialService) { }

  ngOnInit(): void {
    this.booksService.getBooks().subscribe(
      books => {
        this.books = books;
      }
    );

    this.editorialService.getEditorials().subscribe(
      editoriales => {
        this.editoriales = editoriales;
      }
    );

  }

  getEditorial(id: Number): string {
    for(let item of this.editoriales) {
      if(item.id === id) {
          return item.name;
      }
    }
    return "---"; 
  }
}
