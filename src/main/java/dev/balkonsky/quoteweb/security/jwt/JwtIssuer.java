package dev.balkonsky.quoteweb.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {

    private final JwtProperties jwtProperties;

    public String issue(Long userId, String email, List<String> roles){

        Instant now = Instant.now();

        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withIssuedAt(Date.from(now))
                .withClaim("e", email)
                .withClaim("a", roles)
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }
}
