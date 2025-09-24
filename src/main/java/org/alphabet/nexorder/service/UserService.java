package org.alphabet.nexorder.service;

import org.alphabet.nexorder.dto.UserDto;
import org.alphabet.nexorder.enums.Roles;
import org.alphabet.nexorder.mapper.UserMapper;
import org.alphabet.nexorder.model.Role;
import org.alphabet.nexorder.model.User;
import org.alphabet.nexorder.repository.RoleRepository;
import org.alphabet.nexorder.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto saveUser(UserDto user) {
        User newUser = userMapper.toEntity(user);
        Role userRole = roleRepository.findByName(Roles.ROLE_USER.name());
        newUser.setRoles(Set.of(userRole));
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
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

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
