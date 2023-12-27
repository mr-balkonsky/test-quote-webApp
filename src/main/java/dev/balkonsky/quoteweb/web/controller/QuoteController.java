package dev.balkonsky.quoteweb.web.controller;

import dev.balkonsky.quoteweb.service.QuoteService;
import dev.balkonsky.quoteweb.service.VoteService;
import dev.balkonsky.quoteweb.web.dto.QuoteDto;
import dev.balkonsky.quoteweb.web.dto.VoteDto;
import dev.balkonsky.quoteweb.web.mapper.QuoteMapper;
import dev.balkonsky.quoteweb.web.mapper.VoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/quotes")
public class QuoteController {

    private final QuoteService quoteService;
    private final QuoteMapper quoteMapper;
    private final VoteService voteService;
    private final VoteMapper voteMapper;

    @PostMapping("")
    public ResponseEntity<String> addQuote(@RequestBody QuoteDto dto) {
        var quote = quoteMapper.toEntity(dto);
        quoteService.save(quote);
        voteService.setDefaultVote(quote);
        return ResponseEntity.ok("Quote added");
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDto> getRandom() {
        var quote = quoteService.getRandomQuote().orElseThrow();
        var quoteDto = quoteMapper.toDto(quote);
        return ResponseEntity.ok(quoteDto);
    }

    @GetMapping("/top")
    public ResponseEntity<List<QuoteDto>> getTop() {
        var quotes = quoteService.findTopTen();
        var quotesDto = quotes.stream().map(quoteMapper::toDto).toList();
        return ResponseEntity.ok(quotesDto);
    }

    @GetMapping("/flop")
    public ResponseEntity<List<QuoteDto>> getFlop() {
        var quotes = quoteService.findFlopTen();
        var quotesDto = quotes.stream().map(quoteMapper::toDto).toList();
        return ResponseEntity.ok(quotesDto);
    }

    @GetMapping("/last")
    public ResponseEntity<List<QuoteDto>> getLast() {
        var quotes = quoteService.findAllLast();
        var quotesDto = quotes.stream().map(quoteMapper::toDto).toList();
        return ResponseEntity.ok(quotesDto);
    }

    @GetMapping("/by-user-vote/{id}")
    public ResponseEntity<List<QuoteDto>> getByUserVote(@PathVariable Long id){
        var quotes = quoteService.getQuotesByUserVote(id);
        var quotesDto = quotes.stream().map(quoteMapper::toDto).toList();
        return ResponseEntity.ok(quotesDto);
    }

    @GetMapping("/quote/{id}/score")
    public ResponseEntity<Integer> getScoreOfQuote(@PathVariable Long id){
        var score = voteService.getScoreOfQuote(id);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/quote/{id}/edit")
    public ResponseEntity<QuoteDto> getQuoteForUpdate(@PathVariable Long id) {
        var quote = quoteService.findById(id).orElseThrow();
        var dto = quoteMapper.toDto(quote);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/quote/{id}/edit")
    public ResponseEntity<String> updateQuote(@PathVariable Long id, @RequestBody QuoteDto dto) {
        var quote = quoteService.findById(id).orElseThrow();
        quote.setUpdateDate(dto.getUpdateDate());
        quote.setContent(dto.getContent());
        quoteService.save(quote);
        return ResponseEntity.ok("Quote updated!");
    }

    @DeleteMapping("/quote/{id}/delete")
    public ResponseEntity<String> deleteQuote(@PathVariable Long id) {
        var quote = quoteService.findById(id).orElseThrow();
        quoteService.delete(quote);
        return ResponseEntity.ok("Quote deleted!");
    }

    @PostMapping("/quote/vote")
    public ResponseEntity<String> createVote(@RequestBody VoteDto dto) {
        var isPresentVote = voteService.findByQuoteIdAndUserId(dto.getQuoteId(), dto.getUserId()).isPresent();
        if (isPresentVote) {
            return ResponseEntity.ok("0_You have already voted!");
        } else {
            var vote = voteMapper.toEntity(dto);
            voteService.save(vote);
            return ResponseEntity.ok("1_Thanks, your vote to count!");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<QuoteDto>> getUserQuotes(@PathVariable Long id) {
        var quotes = quoteService.findByUser(id);
        var quotesDto = quotes.stream().map(quoteMapper::toDto).toList();
        return ResponseEntity.ok(quotesDto);
    }
}
