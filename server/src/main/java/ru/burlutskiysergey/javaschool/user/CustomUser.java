package ru.burlutskiysergey.javaschool.user;

import lombok.Data;
import ru.burlutskiysergey.javaschool.terminal.Terminal;
import ru.burlutskiysergey.javaschool.card.Card;

@Data
public class CustomUser implements User {
    /** Поле карта */
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
