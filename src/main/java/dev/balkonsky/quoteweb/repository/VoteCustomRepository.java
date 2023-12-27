package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteCustomRepository {

    int getScoreOfQuote(Long quoteId);
    Optional<Vote> findByQuoteIdAndUserId(Long quoteId, Long userId);
}
