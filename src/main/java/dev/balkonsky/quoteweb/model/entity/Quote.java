package dev.balkonsky.quoteweb.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "quote", cascade = CascadeType.REMOVE)
    private List<Vote> votes;


}
