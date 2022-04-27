package service;

import dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> findAll();

    BookDTO create(BookDTO bookDTO);

    Optional<BookDTO> findById(Long id);

    BookDTO update(BookDTO bookDTO);

    void delete(Long id);
}
