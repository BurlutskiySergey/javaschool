package ru.sber.javaschool.card;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardImpl implements Card {
    /** Поле пин-кода */
    private int pinCode;
    /** Поле баланса */
    private BigDecimal balance;

    public boolean checkPin(int pin) {
        return pin == pinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
