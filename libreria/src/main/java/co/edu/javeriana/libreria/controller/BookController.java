/*package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String findAllBooks(Model model){
        List<Book> myBooks = this.bookService.findAllBooks();
        for (int i = 0; i < myBooks.size(); i++) {
            System.out.println(myBooks.get(i).getName());
        }
        model.addAttribute("books", myBooks);
        return "welcome";
    }
}*/

package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.entity.Book;
import co.edu.javeriana.libreria.service.BookService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public Iterable<Book> getAllUsers() {
        return bookService.findAllBooks();
    }

    @GetMapping("/byname/{name}")
    public Iterable<Book> getBooksByName(@PathVariable("name") final String name) {
        return bookService.findBooksByName(name);
    }

    @GetMapping("/byeditorial/{id}")
    public Iterable<Book> getBooksByName(@PathVariable("id") final Integer id) {
        return bookService.findBooksByEditorial(id);
    }

    @PutMapping("/updateAll/{id}")
    public Book updateBook(@RequestBody @Validated Book book, @PathVariable("id") final Integer id) {
        return bookService.updateAllBook(book, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteBook(@PathVariable("id") final Integer id) {
        return bookService.deleteBook(id);
    }
}
