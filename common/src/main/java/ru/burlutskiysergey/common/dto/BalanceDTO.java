package ru.burlutskiysergey.common.dto;

import lombok.*;
import ru.burlutskiysergey.common.Currency;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class BalanceDTO {

    private final Currency currency;

    private final BigDecimal balance;

}
