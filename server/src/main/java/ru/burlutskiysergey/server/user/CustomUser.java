package ru.burlutskiysergey.server.user;

import lombok.Data;
import ru.burlutskiysergey.server.terminal.Terminal;
import ru.burlutskiysergey.server.card.Card;

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
