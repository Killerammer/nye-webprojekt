package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.controller.BookController;
import hu.nye.webapp.books.dto.BookDTO;
import hu.nye.webapp.books.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    private static final Long BOOK_ID = 1L;
    private static final BookDTO BOOK_DTO = new BookDTO();
    private static final BookDTO REQUEST = new BookDTO();
    private static final BookDTO CREATED_BOOK = new BookDTO();
    private static final BookDTO UPDATED_BOOK = new BookDTO();

    private static final String OBJECT_NAME = "objectName";
    private static final String FIELD = "field";
    private static final String DEFAULT_MESSAGE = "defaultMessage";
    private static final FieldError FIELD_ERROR = new FieldError(OBJECT_NAME, FIELD, DEFAULT_MESSAGE);
    private static final List<FieldError> FIELD_ERROR_LIST = List.of(FIELD_ERROR);

    private static final String ERROR_MESSAGE = FIELD + " - " + DEFAULT_MESSAGE;

    @Mock
    private BookService bookService;

    @Mock
    private BindingResult bindingResult;

    private BookController underTest;

    @BeforeEach
    public void setUp() {
        underTest = new BookController(bookService);
    }

    @Test
    public void testFindAllShouldReturnListOfBook() {
        List<BookDTO> bookDTOList = Collections.singletonList(BOOK_DTO);

        given(bookService.findAll()).willReturn(bookDTOList);

        ResponseEntity<List<BookDTO>> result = underTest.findAll();

        ResponseEntity<List<BookDTO>> expected = ResponseEntity.ok().body(bookDTOList);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnBookIfItExists() {
        Optional<BookDTO> bookDTOOptional = Optional.of(BOOK_DTO);

        given(bookService.findById(BOOK_ID)).willReturn(bookDTOOptional);

        ResponseEntity<BookDTO> result = underTest.findById(BOOK_ID);

        ResponseEntity<BookDTO> expected = ResponseEntity.ok(BOOK_DTO);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnNotFoundIfBookDoesNotExist() {
        given(bookService.findById(BOOK_ID)).willReturn(Optional.empty());

        ResponseEntity<BookDTO> result = underTest.findById(BOOK_ID);

        ResponseEntity<BookDTO> expected = ResponseEntity.notFound().build();

        assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateAndReturnNewBookIfRequestIsValid() {
        given(bookService.create(REQUEST)).willReturn(CREATED_BOOK);

        ResponseEntity<BookDTO> result = underTest.create(REQUEST, bindingResult);

        ResponseEntity<BookDTO> expected = ResponseEntity.status(HttpStatus.CREATED)
                .body(CREATED_BOOK);

        assertEquals(expected, result);
    }

    @Test
    public void testUpdateShouldUpdateAndReturnUpdatedBookIfRequestIsValid() {

        given(bookService.update(REQUEST)).willReturn(UPDATED_BOOK);

        ResponseEntity<BookDTO> result = underTest.update(REQUEST, bindingResult);

        ResponseEntity<BookDTO> expected = ResponseEntity.ok(UPDATED_BOOK);

        assertEquals(expected, result);
    }

    @Test
    public void testDeleteShouldDeleteTheRequestedBook() {

        ResponseEntity<Void> result = underTest.delete(BOOK_ID);

        ResponseEntity<Void> expected = ResponseEntity.noContent().build();

        verify(bookService).delete(BOOK_ID);
        assertEquals(expected, result);
    }
}
