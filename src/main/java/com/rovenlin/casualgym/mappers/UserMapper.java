package com.rovenlin.casualgym.mappers;

import com.rovenlin.casualgym.domain.User;
import com.rovenlin.casualgym.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User dtoToUser(UserDTO registrationFormDTO) {
        User user = new User();
        user.setFirstName(registrationFormDTO.getFirstName());
        user.setSecondName(registrationFormDTO.getSecondName());
        user.setPassword(registrationFormDTO.getPassword());
        user.setEmail(registrationFormDTO.getEmail());
        user.setLogin(registrationFormDTO.getLogin());
        return user;
    }

    public UserDTO userToDTO(User user) {
        UserDTO registrationFormDTO = new UserDTO();
        registrationFormDTO.setId(user.getUserId());
        registrationFormDTO.setFirstName(user.getFirstName());
        registrationFormDTO.setSecondName(user.getSecondName());
        registrationFormDTO.setEmail(user.getEmail());
        registrationFormDTO.setLogin(user.getLogin());
        registrationFormDTO.setPassword(user.getPassword());
        return registrationFormDTO;
    }
}
