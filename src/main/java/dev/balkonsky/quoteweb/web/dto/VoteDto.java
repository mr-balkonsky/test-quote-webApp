package dev.balkonsky.quoteweb.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class VoteDto {

    private Long userId;
    private Long quoteId;
    private int rate;
    private LocalDateTime rateDate;
}
