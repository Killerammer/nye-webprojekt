package hu.nye.webapp.books.repository;

import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE genre = ?1", nativeQuery = true)
    List<Book> findByGenre(String genre);
}
