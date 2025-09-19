package org.alphabet.nexorder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.alphabet.nexorder.model.User;

public class UserDto {

    private Long id;

    @NotBlank(message = "firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @NotBlank(message = "email cannot be empty")
    @Email
    private String email;

    @Min(value = 0, message = "age cannot be less than 0")
    private int age;

}
