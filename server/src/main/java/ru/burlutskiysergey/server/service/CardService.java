package ru.burlutskiysergey.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.burlutskiysergey.common.dto.CardDTO;
import ru.burlutskiysergey.common.request.CardVerifyRequest;
import ru.burlutskiysergey.server.entity.Card;
import ru.burlutskiysergey.server.exception.CardNotFoundException;
import ru.burlutskiysergey.server.exception.NotValidCardException;
import ru.burlutskiysergey.server.repository.CardCrudRepository;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CardService {
    private CardCrudRepository cardCrudRepository;

    /**
     * Верификация карты на существование, корректность пин-кода и срока действия
     */
    public boolean verifyCard(CardVerifyRequest cardVerifyRequest) {
        boolean resultValue = Boolean.FALSE;
        Iterable<Card> cardIterable = cardCrudRepository.findAll();
        for (Card card: cardIterable) {
            if (card.getCardNum().equals(cardVerifyRequest.getCardNum())
                    && card.getPin().equals(cardVerifyRequest.getPin())) {
                verifyDate(card);
                resultValue = Boolean.TRUE;
                break;
            }
        }
        return resultValue;
    }

    /**
     * Проверка карты на срок действия
     */
    private void verifyDate(Card card) {
        if (card.getExpiredDate().isBefore(LocalDate.now()))
            throw new NotValidCardException();
    }
}
