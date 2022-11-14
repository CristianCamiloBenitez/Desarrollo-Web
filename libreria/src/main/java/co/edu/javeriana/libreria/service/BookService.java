/*package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList();

        Book sicoanalistaBook = new Book();
        sicoanalistaBook.setName("El Siconalista");
        sicoanalistaBook.setDescription("Frederick Starks, psicoanalista de larga experiencia y vida tranquila, recibe una amenaza anónima. Tendrá que emplear toda su astucia para averiguar quién es el autor de esa misiva que promete hacerle la existencia imposible");
        sicoanalistaBook.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41Zc7DRsnoL._SX327_BO1,204,203,200_.jpg");
        books.add(sicoanalistaBook);

        Book billyBook = new Book();
        billyBook.setName("Billy Summers");
        billyBook.setDescription("Novela sobre un buen tipo con un trabajo muy malo");
        billyBook.setImageUrl("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1618151020l/56852407.jpg");
        books.add(billyBook);

        return books;

    }
}*/

package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.entity.Book;
import co.edu.javeriana.libreria.repository.BookRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

    // POST
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // GET all
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // GET name
    public List<Book> findBooksByName(String name) {
        return bookRepository.findByName(name);
    }

    // GET editorial
    public List<Book> findBooksByEditorial(Integer id) {
        return bookRepository.findByEditorial(id);
    }

    // PUT
    public Book updateAllBook(Book book, Integer bookID) {

        if(bookID != book.getId())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id from path variable does not match object id");

        if(bookRepository.findById(bookID).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not exist");

        return bookRepository.save(book);
    }

    // DELETE
    public String deleteBook(Integer id) {

        if(bookRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not exist");
        }

        bookRepository.deleteById(id);
        return "deleted book with id " + id;
    }
}
