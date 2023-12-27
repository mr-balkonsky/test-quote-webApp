package dev.balkonsky.quoteweb.repository;

import dev.balkonsky.quoteweb.model.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long>, QuoteCustomRepository {
}
