package ru.burlutskiysergey.server.balance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public abstract class Balance {
    /** Поле валюты */
    private Currency currency;

    /** Поле суммы */
    @Setter
    private BigDecimal amount;
}
