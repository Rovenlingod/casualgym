package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.domain.User;
import com.rovenlin.casualgym.dtos.UserDTO;
import com.rovenlin.casualgym.mappers.UserMapper;
import com.rovenlin.casualgym.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User registeredUser = userRepository.save(userMapper.dtoToUser(userDTO));
        return userMapper.userToDTO(registeredUser);
    }
}
