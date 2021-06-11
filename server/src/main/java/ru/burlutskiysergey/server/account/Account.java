package ru.burlutskiysergey.server.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.burlutskiysergey.server.card.Card;
import ru.burlutskiysergey.server.balance.Balance;

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
