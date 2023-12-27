package dev.balkonsky.quoteweb.service;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.Vote;
import dev.balkonsky.quoteweb.repository.VoteRepository;
import dev.balkonsky.quoteweb.web.dto.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService{
    private final VoteRepository voteRepository;

    @Override
    @Transactional
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public List<Vote> findAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    @Override
    public int getScoreOfQuote(Long quoteId) {
        return voteRepository.getScoreOfQuote(quoteId);
    }

    @Override
    public Optional<Vote> findByQuoteIdAndUserId(Long quoteId, Long userId) {
        return voteRepository.findByQuoteIdAndUserId(quoteId, userId);
    }

    @Override
    public void setDefaultVote(Quote quote) {
        var vote = new Vote();
        vote.setQuote(quote);
        vote.setUser(quote.getUser());
        vote.setRate(0);
        vote.setRateDate(quote.getCreationDate());
        voteRepository.save(vote);
    }
}
