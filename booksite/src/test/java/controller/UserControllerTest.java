package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.controller.UserController;
import hu.nye.webapp.books.dto.UserDTO;
import hu.nye.webapp.books.service.UserService;
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
public class UserControllerTest {
    private static final Long USER_ID = 1L;
    private static final UserDTO USER_DTO = new UserDTO();
    private static final UserDTO REQUEST = new UserDTO();
    private static final UserDTO CREATED_USER = new UserDTO();
    private static final UserDTO UPDATED_USER = new UserDTO();

    private static final String OBJECT_NAME = "objectName";
    private static final String FIELD = "field";
    private static final String DEFAULT_MESSAGE = "defaultMessage";
    private static final FieldError FIELD_ERROR = new FieldError(OBJECT_NAME, FIELD, DEFAULT_MESSAGE);
    private static final List<FieldError> FIELD_ERROR_LIST = List.of(FIELD_ERROR);

    private static final String ERROR_MESSAGE = FIELD + " - " + DEFAULT_MESSAGE;

    @Mock
    private UserService userService;

    @Mock
    private BindingResult bindingResult;

    private UserController underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserController(userService);
    }

    @Test
    public void testFindAllShouldReturnListOfUser() {
        List<UserDTO> userDTOList = Collections.singletonList(USER_DTO);

        given(userService.findAll()).willReturn(userDTOList);

        ResponseEntity<List<UserDTO>> result = underTest.findAll();

        ResponseEntity<List<UserDTO>> expected = ResponseEntity.ok().body(userDTOList);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnUserIfItExists() {
        Optional<UserDTO> userDTOOptional = Optional.of(USER_DTO);

        given(userService.findById(USER_ID)).willReturn(userDTOOptional);

        ResponseEntity<UserDTO> result = underTest.findById(USER_ID);

        ResponseEntity<UserDTO> expected = ResponseEntity.ok(USER_DTO);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnNotFoundIfUserDoesNotExist() {
        given(userService.findById(USER_ID)).willReturn(Optional.empty());

        ResponseEntity<UserDTO> result = underTest.findById(USER_ID);

        ResponseEntity<UserDTO> expected = ResponseEntity.notFound().build();

        assertEquals(expected, result);
    }

    @Test
    public void testCreateShouldCreateAndReturnNewUserIfRequestIsValid() {
        given(userService.create(REQUEST)).willReturn(CREATED_USER);

        ResponseEntity<UserDTO> result = underTest.create(REQUEST, bindingResult);

        ResponseEntity<UserDTO> expected = ResponseEntity.status(HttpStatus.CREATED)
                .body(CREATED_USER);

        assertEquals(expected, result);
    }

    @Test
    public void testUpdateShouldUpdateAndReturnUpdatedUserIfRequestIsValid() {

        given(userService.update(REQUEST)).willReturn(UPDATED_USER);

        ResponseEntity<UserDTO> result = underTest.update(REQUEST, bindingResult);

        ResponseEntity<UserDTO> expected = ResponseEntity.ok(UPDATED_USER);

        assertEquals(expected, result);
    }

    @Test
    public void testDeleteShouldDeleteTheRequestedUser() {

        ResponseEntity<Void> result = underTest.delete(USER_ID);

        ResponseEntity<Void> expected = ResponseEntity.noContent().build();

        verify(userService).delete(USER_ID);
        assertEquals(expected, result);
    }
}