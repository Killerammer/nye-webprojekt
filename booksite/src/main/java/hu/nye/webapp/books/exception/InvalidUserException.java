package hu.nye.webapp.books.exception;

import java.util.List;

public class InvalidUserException extends RuntimeException {

    private List<String> errors;

    public InvalidUserException(String message,  List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
