package ru.burlutskiysergey.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String cardNum;
    private LocalDate expiredDate;
    private String pin;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
