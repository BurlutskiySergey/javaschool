package ru.sber.javaschool.card;

import java.math.BigDecimal;

public interface Card {
    boolean checkPin(int pinCode);
    BigDecimal getBalance();
    void setPinCode(int pinCode);
    void setBalance(BigDecimal balance);
}
