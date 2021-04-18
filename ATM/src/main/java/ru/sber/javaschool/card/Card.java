package ru.sber.javaschool.card;

import java.math.BigDecimal;

/**
 * Интерфейс карты
 */
public interface Card {
    /**
     * Проверить пин-код карты
     * @param pinCode - введённый пин-код
     * @return возвращает признак правильно ли введён пин-код
     */
    boolean checkPin(int pinCode);

    /**
     * Получить баланс карты
     * @return возвращает баланс карты
     */
    BigDecimal getBalance();
    void setPinCode(int pinCode);
    void setBalance(BigDecimal balance);
}
