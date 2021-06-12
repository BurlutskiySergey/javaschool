package ru.burlutskiysergey.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class NotValidCardException extends RuntimeException {

    public NotValidCardException() {
    }

    public NotValidCardException(String message) {
        super(message);
    }

    public NotValidCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidCardException(Throwable cause) {
        super(cause);
    }

    public NotValidCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
