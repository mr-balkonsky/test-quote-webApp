package dev.balkonsky.quoteweb.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class QuoteDto {
    private Long id;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private Long userId;
    private String username;

}
