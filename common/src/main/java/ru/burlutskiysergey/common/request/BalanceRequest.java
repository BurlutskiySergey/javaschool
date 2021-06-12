package ru.burlutskiysergey.common.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BalanceRequest {
    private String cardNum;
    public BalanceRequest() {}
}
