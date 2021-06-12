package ru.burlutskiysergey.common.request;

import lombok.Value;

@Value
public class CardVerifyRequest {
    String cardNum;
    String pin;
}
