package dev.balkonsky.quoteweb.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/users/new")
    public String showCreateUserPage() {
        return "createUser";
    }

    @GetMapping("/quotes/add")
    public String showCreateQuotePage() {
        return "createQuote";
    }

    @GetMapping("/quotes/quote/{id}/edit")
    public String showEditQuotePage(@PathVariable("id") Long id) {
        return "editQuote";
    }

    @GetMapping("/quotes/quote/{id}/delete")
    public String showDeleteQuotePage(@PathVariable("id") Long id) {
        return "deleteQuote";
    }

    @GetMapping("/user/{id}")
    public String showProfilePage(@PathVariable("id") Long id) {
        return "profile";
    }

    @GetMapping("/top")
    public String showTopPage() {
        return "top";
    }

    @GetMapping("/flop")
    public String showFlopPage() {
        return "flop";
    }

    @GetMapping("/last")
    public String showLastPage() {
        return "last";
    }

    @GetMapping("/")
    public ResponseEntity<Void> redirect() {
        return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create("/top"))
            .build();
    }
}
