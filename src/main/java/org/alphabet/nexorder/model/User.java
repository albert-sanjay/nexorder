package org.alphabet.nexorder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "firstname cannot be empty")
    private String firstname;

    @Column(nullable = false)
    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "email cannot be empty")
    @Email
    private String email;

    @Column(nullable = false)
    @Min(value = 0, message = "age cannot be less than 0")
    private int age;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {}

    public User(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
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
