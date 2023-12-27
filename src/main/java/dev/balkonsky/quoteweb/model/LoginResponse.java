package dev.balkonsky.quoteweb.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String accessToken;
    private Long userId;
}
