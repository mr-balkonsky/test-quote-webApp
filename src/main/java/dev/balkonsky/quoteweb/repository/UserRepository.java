package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, UserCustomRepository {
}
