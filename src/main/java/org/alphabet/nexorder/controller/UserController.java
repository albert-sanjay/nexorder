package org.alphabet.nexorder.controller;

import jakarta.validation.Valid;
import org.alphabet.nexorder.dto.UserDto;
import org.alphabet.nexorder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> useDto = userService.findAllUsers();

        return ResponseEntity.ok().body(useDto);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto user= userService.saveUser(userDto);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long Id){
        UserDto user = userService.findUserById(Id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
