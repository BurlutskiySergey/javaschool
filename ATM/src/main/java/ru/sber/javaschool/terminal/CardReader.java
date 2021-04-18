package ru.sber.javaschool.terminal;

/**
 * Интерфейс карт-ридера
 */
public interface CardReader {
    /**
     * Принять карту
     */
    void inputCard();

    /**
     * Извлечь карту
     */
    void extractCard();

    /**
     * Проверить наличие карты
     * @return возвращает признак наличия карты в карт-ридере
     */
    boolean checkCardAvailability();
}
