package com.rovenlin.casualgym.repository;

import com.rovenlin.casualgym.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long id);
    User findByLogin(String login);
}
