package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface QuoteCustomRepository{

    List<Quote> findTopTen();
    List<Quote> findFlopTen();
    List<Quote> findByUser(Long userId);
    Optional<Quote> getRandomQuote();
    List<Quote> getQuotesByUserVote(Long userId);
}
