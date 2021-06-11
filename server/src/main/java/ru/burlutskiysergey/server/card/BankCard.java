package ru.burlutskiysergey.server.card;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BankCard implements Card {
    /** Поле пин-кода */
    private int pinCode;
    /** Поле баланса */
    private BigDecimal balance;
    /** Поле номера карты */
    private String cardNum;
    /** Поле истечения срока действия */
    private LocalDate expiredDate;

    @Override
    public boolean checkPin(int pin) {
        return pin == this.pinCode;
    }
}
