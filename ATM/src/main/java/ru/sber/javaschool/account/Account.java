package ru.sber.javaschool.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.sber.javaschool.balance.Balance;
import ru.sber.javaschool.card.Card;

import java.util.List;

@AllArgsConstructor
public class Account<T extends Balance> {
    /** Поле номера счёта */
    private String accountNum;
    /** Поле баланса */
    @Getter
    private T balance;
    /** Коллекция из привязанных к счету карт */
    private List<Card> cards;
}
