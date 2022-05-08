package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import hu.nye.webapp.books.controller.UserControllerAdvice;
import hu.nye.webapp.books.exception.InvalidUserException;
import hu.nye.webapp.books.exception.UserNotFoundException;
import hu.nye.webapp.books.response.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class UserControllerAdviceTest {
    private static final String EXCEPTION_MESSAGE = "exceptionMessage";

    private static final String ERROR_MESSAGE_1 = "errorMessage1";
    private static final String ERROR_MESSAGE_2 = "errorMessage2";
    private static final List<String> ERROR_MESSAGE_LIST = List.of(ERROR_MESSAGE_1, ERROR_MESSAGE_2);
    private static final InvalidUserException INVALID_USER_REQUEST_EXCEPTION =
            new InvalidUserException(EXCEPTION_MESSAGE, ERROR_MESSAGE_LIST);

    private static final UserNotFoundException USER_NOT_FOUND_EXCEPTION =
            new UserNotFoundException(EXCEPTION_MESSAGE);

    private UserControllerAdvice underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserControllerAdvice();
    }

    @Test
    public void testInvalidRequestHandlerShouldReturnBadRequestErrorWithErrorMessagesFromException() {

        ResponseEntity<ErrorResponse> result = underTest.handleInvalidUserException(INVALID_USER_REQUEST_EXCEPTION);

        ResponseEntity<ErrorResponse> expected = ResponseEntity.badRequest()
                .body(new ErrorResponse(ERROR_MESSAGE_LIST));

        assertEquals(expected, result);
    }

    @Test
    public void testUserNotFoundHandlerShouldReturnEmptyResponseWithNotFoundStatusCode() {

        ResponseEntity<Void> result = underTest.handleUserNotFoundException(USER_NOT_FOUND_EXCEPTION);

        ResponseEntity<Void> expected = ResponseEntity.notFound().build();

        assertEquals(expected, result);
    }
}
