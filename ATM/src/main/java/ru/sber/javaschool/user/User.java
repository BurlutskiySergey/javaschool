package ru.sber.javaschool.user;

import ru.sber.javaschool.terminal.Terminal;

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
}
