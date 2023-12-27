package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.User;
import dev.balkonsky.quoteweb.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService{

    private final QuoteRepository quoteRepository;

    @Override
    @Transactional
    public void save(Quote quote) {
        quoteRepository.save(quote);
    }

    @Override
    public List<Quote> findAllLast() {
        Sort sortByCreationDate = Sort.by("creationDate").descending();
        return quoteRepository.findAll(sortByCreationDate);
    }

    @Override
    public List<Quote> findTopTen() {
        return quoteRepository.findTopTen();
    }

    @Override
    public List<Quote> findFlopTen() {
        return quoteRepository.findFlopTen();
    }

    @Override
    public List<Quote> findByUser(Long userId) {
        return quoteRepository.findByUser(userId);
    }

    @Override
    @Transactional
    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }

    @Override
    public Optional<Quote> findById(Long id) {
        return quoteRepository.findById(id);
    }

    @Override
    public Optional<Quote> getRandomQuote() {
        return quoteRepository.getRandomQuote();
    }

    @Override
    public List<Quote> getQuotesByUserVote(Long userId) {
        return quoteRepository.getQuotesByUserVote(userId);
    }
}
