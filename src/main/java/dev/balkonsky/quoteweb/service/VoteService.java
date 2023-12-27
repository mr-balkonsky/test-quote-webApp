package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteService {
    void save(Vote vote);
    List<Vote> findAll();
    int getScoreOfQuote(Long quoteId);
    Optional<Vote> findByQuoteIdAndUserId(Long quoteId, Long userId);
    void setDefaultVote(Quote quote);
}
