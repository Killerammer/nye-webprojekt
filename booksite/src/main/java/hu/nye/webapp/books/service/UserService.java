package hu.nye.webapp.books.service;

import java.util.List;
import java.util.Optional;

import hu.nye.webapp.books.dto.UserDTO;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO create(UserDTO userDTO);

    Optional<UserDTO> findById(Long id);

    UserDTO update(UserDTO userDTO);

    void delete(Long id);
}
