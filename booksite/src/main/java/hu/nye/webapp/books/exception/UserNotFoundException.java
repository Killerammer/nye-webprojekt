package hu.nye.webapp.books.exception;

public class UserNotFoundException extends  RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
