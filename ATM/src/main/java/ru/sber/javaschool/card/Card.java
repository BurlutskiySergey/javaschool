package ru.sber.javaschool.card;

import java.math.BigDecimal;

public interface Card {
    boolean checkPin(int pinCode);
    BigDecimal getBalance();
}
