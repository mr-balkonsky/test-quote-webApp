package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.User;

import java.util.Optional;

public interface UserCustomRepository {

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
