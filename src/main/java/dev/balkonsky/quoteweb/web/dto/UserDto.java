package dev.balkonsky.quoteweb.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDate creationDate;
}
