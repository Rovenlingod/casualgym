package com.rovenlin.casualgym.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    private Long id;
    @Size(min = 6, message = "Login must have at least 6 characters")
    private String login;
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotBlank(message = "Second name is mandatory")
    private String secondName;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String email;
}