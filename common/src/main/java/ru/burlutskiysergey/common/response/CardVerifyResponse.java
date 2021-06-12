package ru.burlutskiysergey.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardVerifyResponse {
    private boolean result;

    public CardVerifyResponse() {
        this.result = Boolean.FALSE;
    }
}
