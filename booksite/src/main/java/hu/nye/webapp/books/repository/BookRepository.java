package hu.nye.webapp.books.repository;

import hu.nye.webapp.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
