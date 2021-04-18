package ru.sber.javaschool.terminal;

import ru.sber.javaschool.card.Card;

public interface Terminal {
    void start(Card card);
    void showBalance(Card card);
    void stop();
    void setCardReader(CardReader cardReader);
}
