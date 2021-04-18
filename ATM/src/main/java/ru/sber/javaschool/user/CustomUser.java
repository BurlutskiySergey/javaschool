package ru.sber.javaschool.user;

import lombok.Data;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.terminal.Terminal;

@Data
public class CustomUser implements User {
    private Card card;

    @Override
    public void insertCard(Terminal terminal) {
        terminal.start(card);
    }

    @Override
    public void requestBalance(Terminal terminal) {
        terminal.showBalance(card);
    }
}
