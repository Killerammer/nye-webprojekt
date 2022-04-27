package controller;

import exception.BookNotFoundException;
import exception.InvalidBookException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import response.ErrorResponse;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerAdvice {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Void> handleBookNotFoundException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = InvalidBookException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookException(InvalidBookException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessages());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
