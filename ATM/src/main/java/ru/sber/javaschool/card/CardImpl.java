package ru.sber.javaschool.card;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardImpl implements Card {
    private int pinCode;
    private BigDecimal balance;

    public boolean checkPin(int pin) {
        return pin == pinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
