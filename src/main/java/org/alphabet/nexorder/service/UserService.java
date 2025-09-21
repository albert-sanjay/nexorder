package org.alphabet.nexorder.service;

import org.alphabet.nexorder.dto.UserDto;
import org.alphabet.nexorder.mapper.UserMapper;
import org.alphabet.nexorder.model.User;
import org.alphabet.nexorder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(UserDto user) {
        User newUser = userMapper.toEntity(user);
        userRepository.save(newUser);

        return userMapper.toDto(newUser);
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userMapper.toDto(user);
    }
}
