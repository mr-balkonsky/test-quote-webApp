package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByName(String name) {

        var query = "SELECT id, email, name, password, creation_date FROM users WHERE name = :name";
        var user = (User) entityManager.createNativeQuery(query, User.class).setParameter("name", name).getSingleResult();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        var query = "SELECT id, email, name, password, creation_date FROM users WHERE email = :email";
        var user = (User) entityManager.createNativeQuery(query, User.class).setParameter("email", email).getSingleResult();
        return Optional.ofNullable(user);
    }

}
