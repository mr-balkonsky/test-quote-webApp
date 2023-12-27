package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuoteCustomRepositoryImpl implements QuoteCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Quote> findTopTen() {
        var query = "SELECT id, content, creation_date, update_date, user_id FROM quotes q JOIN ( SELECT quote_id, SUM(rate) AS top FROM votes GROUP BY quote_id ORDER BY top DESC LIMIT 10 ) AS top_quotes ON q.id = top_quotes.quote_id ORDER BY top_quotes.top DESC;";
        return entityManager.createNativeQuery(query, Quote.class).getResultList();
    }

    @Override
    public List<Quote> findFlopTen() {
        var query = "SELECT id, content, creation_date, update_date, user_id FROM quotes q JOIN ( SELECT quote_id, SUM(rate) AS flop FROM votes GROUP BY quote_id ORDER BY flop LIMIT 10 ) AS flop_quotes ON q.id = flop_quotes.quote_id ORDER BY flop_quotes.flop";
        return entityManager.createNativeQuery(query, Quote.class).getResultList();
    }

    @Override
    public List<Quote> findByUser(Long userId) {
        var query = "SELECT id, content, creation_date, update_date, user_id FROM quotes WHERE user_id = :userId";
        return entityManager.createNativeQuery(query, Quote.class)
            .setParameter("userId", userId)
            .getResultList();
    }

    @Override
    public Optional<Quote> getRandomQuote() {
        var query = "SELECT id, content, creation_date, update_date, user_id FROM quotes ORDER BY RAND() LIMIT 1";
        var quote = (Quote) entityManager.createNativeQuery(query, Quote.class).getSingleResult();
        return Optional.ofNullable(quote);
    }

    @Override
    public List<Quote> getQuotesByUserVote(Long userId) {
        var query = "SELECT id, content, creation_date, update_date, user_id FROM quotes q JOIN (SELECT quote_id, rate_date FROM votes WHERE user_id = :userId ORDER BY rate_date DESC LIMIT 5) AS user_votes ON q.id = user_votes.quote_id WHERE q.user_id != :userId ORDER BY user_votes.rate_date DESC";
        return entityManager.createNativeQuery(query, Quote.class)
            .setParameter("userId", userId)
            .getResultList();
    }
}
