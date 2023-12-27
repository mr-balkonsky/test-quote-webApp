package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long>, VoteCustomRepository {
}
