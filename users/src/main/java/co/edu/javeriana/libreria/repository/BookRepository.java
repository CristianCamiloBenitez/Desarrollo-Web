package co.edu.javeriana.libreria.repository;

import co.edu.javeriana.libreria.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query(value = "SELECT * FROM books WHERE name LIKE %?1%", nativeQuery = true)
    List<Book> findByName(String name);

    @Query(value = "SELECT * FROM books WHERE editorial_id = ?1", nativeQuery = true)
    List<Book> findByEditorial(Integer id);
}
