package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.User;

import java.util.Optional;

public interface UserService {
    void save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
