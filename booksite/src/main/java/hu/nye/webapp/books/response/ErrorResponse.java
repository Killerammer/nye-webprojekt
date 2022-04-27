package hu.nye.webapp.books.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    private List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.messages = messages;
    }

}
