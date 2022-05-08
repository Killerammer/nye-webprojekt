package hu.nye.webapp.books.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hu.nye.webapp.books.dto.UserDTO;
import hu.nye.webapp.books.entity.User;
import hu.nye.webapp.books.exception.UserNotFoundException;
import hu.nye.webapp.books.repository.UserRepository;
import hu.nye.webapp.books.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();

        return userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User userToSave = modelMapper.map(userDTO, User.class);
        userToSave.setId(null);
        User savedUser = userRepository.save(userToSave);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Long id = userDTO.getId();
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found with id=" + id);
        }

        User userToUpdate = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(userToUpdate);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User userToDelete = optionalUser.get();
            userRepository.delete(userToDelete);
        } else {
            throw new UserNotFoundException("User not found with id=" + id);
        }
    }
}
