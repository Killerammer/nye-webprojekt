package hu.nye.webapp.books.controller;

import hu.nye.webapp.books.exception.InvalidUserException;
import hu.nye.webapp.books.exception.UserNotFoundException;
import hu.nye.webapp.books.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserControllerAdvice {

    @ExceptionHandler(value = InvalidUserException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserException(InvalidUserException invalidUserException) {
        ErrorResponse errorResponse = new ErrorResponse(invalidUserException.getErrors());
        return ResponseEntity.badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Void> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return ResponseEntity.notFound()
                .build();
    }
}