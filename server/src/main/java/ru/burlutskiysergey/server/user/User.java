package ru.burlutskiysergey.server.user;

import ru.burlutskiysergey.server.terminal.Terminal;
import ru.burlutskiysergey.server.card.Card;

/**
 * Интерфейс пользователя
 */
public interface User {
    /**
     * Вставить карту в терминал
     * @param terminal - терминал
     */
    void insertCard(Terminal terminal);

    /**
     * Запросить баланс в терминале
     * @param terminal - терминал
     */
    void requestBalance(Terminal terminal);
    void setCard(Card card);
}
