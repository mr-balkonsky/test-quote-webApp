package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Vote;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VoteCustomRepositoryImpl implements VoteCustomRepository{

    private final EntityManager entityManager;

    @Override
    public int getScoreOfQuote(Long quoteId) {
        var query = "SELECT sum(rate) FROM votes WHERE quote_id = :quoteId";
        var score = (Number) entityManager.createNativeQuery(query).setParameter("quoteId", quoteId).getSingleResult();
        return score != null ? score.intValue() : 0;
    }

    @Override
    public Optional<Vote> findByQuoteIdAndUserId(Long quoteId, Long userId) {
        var query = "SELECT id, quote_id, user_id, rate, rate_date FROM votes WHERE quote_id = :quoteId AND user_id = :userId";
        List<Vote> votes = entityManager.createNativeQuery(query, Vote.class)
                .setParameter("quoteId", quoteId)
                .setParameter("userId", userId)
                .getResultList();
        if (!votes.isEmpty()) {
            return Optional.of(votes.get(0));
        } else {
            return Optional.empty();
        }
    }
}
