package ru.sber.javaschool.card;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankCard implements Card {
    /** Поле пин-кода */
    private int pinCode;
    /** Поле баланса */
    private BigDecimal balance;

    @Override
    public boolean checkPin(int pin) {
        return pin == this.pinCode;
    }
}
