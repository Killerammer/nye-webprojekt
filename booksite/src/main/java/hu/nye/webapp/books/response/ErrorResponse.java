package hu.nye.webapp.books.response;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ErrorResponse {

    private List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.messages = messages;
    }

}
