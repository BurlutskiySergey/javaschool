package ru.sber.javaschool.terminal;

import ru.sber.javaschool.card.Card;

/**
 * Интерфейс терминала
 */
public interface Terminal {
    /**
     * Начать работу
     * @param card - карта, с которой работает терминал
     */
    void start(Card card);

    /**
     * Показать баланс карты
     * @param card - карта, с которой работает терминал
     */
    void showBalance(Card card);

    /**
     * Остановить работу
     */
    void stop();
}
