package hu.nye.webapp.books.service.impl;
import hu.nye.webapp.books.dto.BookDTO;
import hu.nye.webapp.books.entity.Book;
import hu.nye.webapp.books.exception.BookNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import hu.nye.webapp.books.repository.BookRepository;
import hu.nye.webapp.books.service.BookService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookDTO> findAll() {
        List<Book> bookList = bookRepository.findAll();

        return bookList.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO create(BookDTO bookDTO) {
        Book bookToSave = modelMapper.map(bookDTO, Book.class);
        bookToSave.setId(null);
        Book savedBook = bookRepository.save(bookToSave);
        return modelMapper.map(savedBook, BookDTO.class);
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(book -> modelMapper.map(book, BookDTO.class));
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        Long id = bookDTO.getId();
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book not found with id=" + id);
        }

        Book bookToUpdate = modelMapper.map(bookDTO, Book.class);
        Book savedBook = bookRepository.save(bookToUpdate);
        return modelMapper.map(savedBook, BookDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()) {
            Book bookToDelete = optionalBook.get();
            bookRepository.delete(bookToDelete);
        } else {
            throw new BookNotFoundException("Book not found with id=" + id);
        }
    }

}
