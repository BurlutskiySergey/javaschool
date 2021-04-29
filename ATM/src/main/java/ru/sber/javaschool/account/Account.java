package ru.sber.javaschool.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.sber.javaschool.balance.Balance;
import ru.sber.javaschool.card.Card;

import java.util.List;

@AllArgsConstructor
public class Account<T extends Balance> {
    /** Поле номера счёта */
    @Getter
    private String accountNum;
    /** Поле баланса */
    @Getter
    private T balance;
    /** Коллекция из привязанных к счету карт */
    private List<Card> cards;

    /**
     * Метод получения информации о карте по номеру
     * @param cardNum - номер карты
     * @return найденная карта
     */
    public Card findCard (String cardNum) {
        return cards.stream().filter(card -> card.getCardNum().equals(cardNum)).findAny().orElse(null);
    }
}
