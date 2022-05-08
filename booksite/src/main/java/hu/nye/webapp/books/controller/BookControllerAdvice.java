package hu.nye.webapp.books.controller;

import hu.nye.webapp.books.exception.BookNotFoundException;
import hu.nye.webapp.books.exception.InvalidBookException;
import hu.nye.webapp.books.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerAdvice {

    @ExceptionHandler(value = InvalidBookException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookException(InvalidBookException invalidBookException) {
        ErrorResponse errorResponse = new ErrorResponse(invalidBookException.getErrors());
        return ResponseEntity.badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Void> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        return ResponseEntity.notFound()
                .build();
    }

}
