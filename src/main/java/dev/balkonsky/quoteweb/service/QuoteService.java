package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.User;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface QuoteService {
    void save(Quote quote);
    List<Quote> findTopTen();
    List<Quote> findFlopTen();
    List<Quote> findAllLast();
    List<Quote> findByUser(Long userId);
    void delete(Quote quote);
    Optional<Quote> findById(Long id);
    Optional<Quote> getRandomQuote();
    List<Quote> getQuotesByUserVote(Long userId);


}
