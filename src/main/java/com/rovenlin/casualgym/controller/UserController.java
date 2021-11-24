package com.rovenlin.casualgym.controller;

import com.rovenlin.casualgym.dtos.UserDTO;
import com.rovenlin.casualgym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registerUser(@Valid @RequestBody UserDTO registrationForm) {
        return ResponseEntity.ok().body(userService.registerUser(registrationForm));
    }


}
