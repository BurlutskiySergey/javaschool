package ru.sber.javaschool.user;

import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.terminal.Terminal;

public interface User {
    void insertCard(Terminal terminal);
    void requestBalance(Terminal terminal);
    void setCard(Card card);
}
