package ru.sber.javaschool.card;

import java.time.LocalDate;

/**
 * Интерфейс карты
 */
public interface Card {
    /**
     * Получить пин-код карты
     * @return возвращает пин-код карты
     */
    int getPinCode();

    /**
     * Получить номер карты
     * @return номер карты
     */
    String getCardNum();

    /**
     * Получить дату истечения карты
     * @return дата истечения карты
     */
    LocalDate getExpiredDate();
}
