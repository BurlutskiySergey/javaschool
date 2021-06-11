package ru.burlutskiysergey.server.balance;

import java.math.BigDecimal;

public class BalanceOverdraft extends Balance {
    /** Поле лимита овердрафта */
    private BigDecimal limit;

    public BalanceOverdraft(Currency currency, BigDecimal amount, BigDecimal limit) {
        super(currency, amount);
        this.limit = limit;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(limit) < 0)
            throw new BalanceException("Превышение лимита овердрафта");
        super.setAmount(amount);
    }
}
