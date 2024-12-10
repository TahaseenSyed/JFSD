package com.klu.studentlearningtracer.repository;

import com.klu.studentlearningtracer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
