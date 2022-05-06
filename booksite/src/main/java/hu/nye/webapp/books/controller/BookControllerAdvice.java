package hu.nye.webapp.books.controller;

import hu.nye.webapp.books.exception.BookNotFoundException;
import hu.nye.webapp.books.exception.InvalidBookException;
import hu.nye.webapp.books.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerAdvice {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Void> handleBookNotFoundException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = InvalidBookException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookException(InvalidBookException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessages());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
