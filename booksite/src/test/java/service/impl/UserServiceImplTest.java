package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.dto.UserDTO;
import hu.nye.webapp.books.entity.User;
import hu.nye.webapp.books.exception.UserNotFoundException;
import hu.nye.webapp.books.repository.UserRepository;
import hu.nye.webapp.books.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private static final Long USER_ID = 1L;

    private static final User USER = new User();
    private static final UserDTO USER_DTO = new UserDTO();

    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    private UserServiceImpl underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserServiceImpl(userRepository, modelMapper);
    }

    @Test
    public void testFindAllShouldReturnAllUser() {
        given(userRepository.findAll()).willReturn(Collections.singletonList(USER));
        given(modelMapper.map(USER, UserDTO.class)).willReturn(USER_DTO);

        List<UserDTO> result = underTest.findAll();

        List<UserDTO> expected = Collections.singletonList(USER_DTO);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnUserInOptionalIfItExists() {
        given(userRepository.findById(USER_ID)).willReturn(Optional.of(USER));
        given(modelMapper.map(USER, UserDTO.class)).willReturn(USER_DTO);

        Optional<UserDTO> result = underTest.findById(USER_ID);

        Optional<UserDTO> expected = Optional.of(USER_DTO);

        assertEquals(expected, result);
    }

    @Test
    public void testFindByIdShouldReturnEmptyOptionalIfUserNotFound() {
        given(userRepository.findById(USER_ID)).willReturn(Optional.empty());

        Optional<UserDTO> result = underTest.findById(USER_ID);

        Optional<UserDTO> expected = Optional.empty();

        assertEquals(expected, result);
    }

    @Test
    public void testUpdateShouldUpdateAndReturnUserIfItExists() {
        UserDTO userDTOToUpdate = UserDTO.builder()
                .id(USER_ID)
                .build();
        User storedUser = new User();
        Optional<User> storedUserOptional = Optional.of(storedUser);
        User userToUpdate = new User();
        User updatedUser = new User();
        UserDTO updatedUserDTO = new UserDTO();

        given(userRepository.findById(USER_ID)).willReturn(storedUserOptional);
        given(modelMapper.map(userDTOToUpdate, User.class)).willReturn(userToUpdate);
        given(userRepository.save(userToUpdate)).willReturn(updatedUser);
        given(modelMapper.map(updatedUser, UserDTO.class)).willReturn(updatedUserDTO);

        UserDTO result = underTest.update(userDTOToUpdate);

        assertEquals(updatedUserDTO, result);
    }

    @Test
    public void testUpdateShouldThrowExceptionIfUserNotFound() {
        UserDTO userDTOToUpdate = UserDTO.builder()
                .id(USER_ID)
                .build();

        given(userRepository.findById(USER_ID)).willReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {
            underTest.update(userDTOToUpdate);
        });
    }

    @Test
    public void testDeleteShouldDeleteRequestedUser() {
        User userToDelete = new User();
        userToDelete.setId(USER_ID);
        Optional<User> userToDeleteOptional = Optional.of(userToDelete);

        given(userRepository.findById(USER_ID)).willReturn(userToDeleteOptional);

        underTest.delete(USER_ID);

        verify(userRepository).delete(userToDelete);
    }

    @Test
    public void testDeleteShouldThrowExceptionIfUserNotFound() {

        given(userRepository.findById(USER_ID)).willReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {
            underTest.delete(USER_ID);
        });
    }
}
