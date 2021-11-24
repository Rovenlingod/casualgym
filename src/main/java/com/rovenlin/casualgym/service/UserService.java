package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.domain.User;
import com.rovenlin.casualgym.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    User findByLogin(String login);
}
