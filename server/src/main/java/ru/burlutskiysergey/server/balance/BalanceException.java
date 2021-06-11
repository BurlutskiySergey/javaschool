package ru.burlutskiysergey.server.balance;

public class BalanceException extends RuntimeException {
    public BalanceException() {
        super();
    }

    public BalanceException(String message) {
        super(message);
    }

    public BalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BalanceException(Throwable cause) {
        super(cause);
    }

    protected BalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
