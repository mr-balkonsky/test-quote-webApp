package dev.balkonsky.quoteweb.web.mapper;

import dev.balkonsky.quoteweb.model.entity.Vote;
import dev.balkonsky.quoteweb.service.QuoteService;
import dev.balkonsky.quoteweb.service.UserService;
import dev.balkonsky.quoteweb.web.dto.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class VoteMapperImpl implements VoteMapper{

    private final UserService userService;
    private final QuoteService quoteService;

    @Override
    public Vote toEntity(VoteDto dto) {
        var vote = new Vote();
        var user = userService.findById(dto.getUserId()).orElseThrow();
        vote.setUser(user);
        var quote = quoteService.findById(dto.getQuoteId()).orElseThrow();
        vote.setQuote(quote);
        vote.setRate(dto.getRate());
        vote.setRateDate(dto.getRateDate());
        return vote;
    }

    @Override
    public VoteDto toDto(Vote vote) {

        var dto = new VoteDto();
        dto.setUserId(vote.getUser().getId());
        dto.setQuoteId(vote.getQuote().getId());
        dto.setRate(vote.getRate());
        dto.setRateDate(vote.getRateDate());
        return dto;
    }
}
