package org.alphabet.nexorder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.alphabet.nexorder.model.User;

public class UserDto {

    private Long id;

    @NotBlank(message = "firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "must be a valid email")
    private String email;

    @NotNull(message = "age is required")
    @Min(value = 0, message = "age cannot be less than 0")
    private int age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
