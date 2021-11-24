package com.rovenlin.casualgym.security.jwt;

import com.rovenlin.casualgym.domain.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getLogin(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail(),
                user.getPassword()
        );
    }


}