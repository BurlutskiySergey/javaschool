package ru.burlutskiysergey.server.balance;

import java.math.BigDecimal;

public class BalanceNotOverdraft extends Balance {
    public BalanceNotOverdraft(Currency currency, BigDecimal amount) {
        super(currency, amount);
    }

    @Override
    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new BalanceException("Баланс не может быть меньше 0");
        super.setAmount(amount);
    }
}
