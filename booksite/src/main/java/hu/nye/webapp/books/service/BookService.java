package hu.nye.webapp.books.service;

import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.dto.BookDTO;

public interface BookService {
    List<BookDTO> findAll();

    BookDTO create(BookDTO bookDTO);

    Optional<BookDTO> findById(Long id);

    BookDTO update(BookDTO bookDTO);

    void delete(Long id);
}
