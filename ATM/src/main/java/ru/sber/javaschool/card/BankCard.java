package ru.sber.javaschool.card;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BankCard implements Card {
    /** Поле пин-кода */
    private int pinCode;
    /** Поле номера карты */
    private String cardNum;
    /** Поле истечения срока действия */
    private LocalDate expiredDate;
}
