package ru.burlutskiysergey.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class CardDTO {

    private final long cardId;

    @NotBlank(message = "Необходимо указать номер карты")
    private final String cardNum;

    @Past(message = "Дата окончания срока действия карты не должно быть меньше текущей даты")
    private final LocalDate expiredDate;

    @Pattern(regexp = "[0-9]{4}", message = "Необходимо указать пин-код(4 цифры)")
    private final String pin;
}
