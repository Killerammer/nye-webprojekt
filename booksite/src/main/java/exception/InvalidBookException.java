package exception;

import java.util.List;

public class InvalidBookException extends RuntimeException{

    private List<String> messages;

    public InvalidBookException(String message, List<String> messages) {
        super(message);
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
