package hu.nye.webapp.books.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;

import hu.nye.webapp.books.dto.BookDTO;
import hu.nye.webapp.books.exception.InvalidBookException;
import hu.nye.webapp.books.service.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/books")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BookDTO> create(@RequestBody @Valid BookDTO bookDTO, BindingResult bindingResult) {
        checkErrors(bindingResult);
        BookDTO savedBook = bookService.create(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookDTO> findById(@PathVariable(name = "id") Long identifier) {
        Optional<BookDTO> optionalBookDTO = bookService.findById(identifier);

        ResponseEntity<BookDTO> response;

        if (optionalBookDTO.isPresent()) {
            response = ResponseEntity.ok(optionalBookDTO.get());
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return response;
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<BookDTO>> findByGenre(@PathVariable(name = "genre") String genre) {
        List<BookDTO> optionalBookDTO = bookService.findByGenre(genre);
        return ResponseEntity.ok(optionalBookDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<BookDTO> update(@RequestBody @Valid BookDTO bookDTO, BindingResult bindingResult) {
        checkErrors(bindingResult);
        BookDTO updatedBook = bookService.update(bookDTO);
        return ResponseEntity.ok()
                .body(updatedBook);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void checkErrors(BindingResult bindingResult) {
        LOGGER.info("bindingResult has errors = {}", bindingResult.hasErrors());
        LOGGER.info("errors = {}", bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(this::fieldErrorToMessage)
                    .collect(Collectors.toList());

            throw new InvalidBookException("Invalid book", errors);
        }
    }

    private String fieldErrorToMessage(FieldError fieldError) {
        return fieldError.getField() + " - " + fieldError.getDefaultMessage();
    }
}
