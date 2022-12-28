package com.delivery.api.service.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserRequestDTO {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\d]{4,20}", message = "Must consist of uppercase or lowercase letters and can contain a numbers, and be between 4 and 20 characters long")
    private String login;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, at least one letter and one number")
    private String password;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, at least one letter and one number")
    private String confirmPassword;

    @NotNull
    @Pattern(regexp = "^[a-zA-ZА-Яа-яЇїіІ]{4,20}", message = "Must consist of uppercase or lowercase letters, and be between 4 and 20 characters long")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[a-zA-ZА-Яа-яЇїіІ]{4,20}", message = "Must consist of uppercase or lowercase letters, and be between 4 and 20 characters long")
    private String lastName;


    @NotNull
    @Pattern(regexp = "\\+380\\d{9}", message = "Must be 10 digits and begin with 0 or +380")
    private String phoneNumber;

    @NotNull
    private Boolean notify;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String role;
}
