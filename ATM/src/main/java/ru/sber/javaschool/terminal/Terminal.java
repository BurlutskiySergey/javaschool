package ru.sber.javaschool.terminal;

import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.processing.ProcessingException;

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
    void showBalance(Card card) throws ProcessingException;

    /**
     * Остановить работу
     */
    void stop();
}
