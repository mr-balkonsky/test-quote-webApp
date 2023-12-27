package dev.balkonsky.quoteweb.web.mapper;

import dev.balkonsky.quoteweb.model.entity.Quote;
import dev.balkonsky.quoteweb.model.entity.User;
import dev.balkonsky.quoteweb.service.UserService;
import dev.balkonsky.quoteweb.web.dto.QuoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class QuoteMapperImpl implements QuoteMapper{

    private final UserService userService;

    @Override
    public Quote toEntity(QuoteDto dto) {

        Quote quote = new Quote();
        quote.setId(dto.getId());
        quote.setContent(dto.getContent());
        quote.setCreationDate(dto.getCreationDate());
        quote.setUpdateDate(dto.getUpdateDate());
        User user = userService.findById(dto.getUserId()).orElseThrow();
        quote.setUser(user);

        return quote;
    }

    @Override
    public QuoteDto toDto(Quote quote) {

        QuoteDto dto = new QuoteDto();
        dto.setId(quote.getId());
        dto.setContent(quote.getContent());
        dto.setCreationDate(quote.getCreationDate());
        dto.setUpdateDate(quote.getUpdateDate());
        User user = quote.getUser();
        dto.setUserId(user.getId());
        dto.setUsername(user.getName());
        return dto;
    }
}
