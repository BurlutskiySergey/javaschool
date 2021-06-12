package ru.burlutskiysergey.server.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.burlutskiysergey.common.request.CardVerifyRequest;
import ru.burlutskiysergey.common.response.CardVerifyResponse;
import ru.burlutskiysergey.server.exception.NotValidCardException;
import ru.burlutskiysergey.server.service.CardService;

@RestController
@AllArgsConstructor
@Log
public class CardRestController {
    private CardService cardService;

    /**
     * Запрос верификации карты
     */
    @PostMapping(value = "/verifycard", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CardVerifyResponse verifyCard(@RequestBody CardVerifyRequest cardVerifyRequest) {
        log.info("Запрос верификации карты");

        CardVerifyResponse cardVerifyResponse = new CardVerifyResponse();
        try {
            if (cardService.verifyCard(cardVerifyRequest)) {
                cardVerifyResponse.setResult(Boolean.TRUE);
            }
        } catch (Exception e) {
            throw new NotValidCardException("Bad request");
        }
        return cardVerifyResponse;
    }
}
