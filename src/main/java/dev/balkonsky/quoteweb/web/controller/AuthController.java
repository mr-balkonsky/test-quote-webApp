package dev.balkonsky.quoteweb.web.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import dev.balkonsky.quoteweb.model.LoginRequest;
import dev.balkonsky.quoteweb.model.LoginResponse;
import dev.balkonsky.quoteweb.security.principal.UserPrincipal;
import dev.balkonsky.quoteweb.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

}
