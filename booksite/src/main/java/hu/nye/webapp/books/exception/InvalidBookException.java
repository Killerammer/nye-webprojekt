package hu.nye.webapp.books.exception;

import java.util.List;

public class InvalidBookException extends RuntimeException {

    private List<String> errors;

    public InvalidBookException(String message,  List<String> erros) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
