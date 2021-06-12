package ru.burlutskiysergey.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class AccountDTO {

    private final long accountId;

    @NotBlank(message = "Необходимо указать номер лицевого счета")
    private final String accountNum;

    private final List<CardDTO> cardsDTO;

    private final BalanceDTO balanceDTO;
}

