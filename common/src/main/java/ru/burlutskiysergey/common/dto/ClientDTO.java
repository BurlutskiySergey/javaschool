package ru.burlutskiysergey.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class ClientDTO {

    private final long id;

    @NotBlank(message = "Необходимо указать номер клиента")
    private final int clientNum;

    private final String fullName;

    @NotBlank(message = "Необходимо указать количество лет")
    private final int age;

    private final List<AccountDTO> accountsDTO;
}

