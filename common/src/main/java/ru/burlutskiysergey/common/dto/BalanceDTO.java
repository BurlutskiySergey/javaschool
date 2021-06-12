package ru.burlutskiysergey.common.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class BalanceDTO {

    @NotBlank(message = "Необходимо указать валюту")
    private final String currency;

    @NotBlank(message = "Необходимо указать баланс счёта")
    private final BigDecimal balance;

}
