package ru.burlutskiysergey.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.burlutskiysergey.client.exception.ATMBalanceException;
import ru.burlutskiysergey.client.exception.ATMVerifyCardException;
import ru.burlutskiysergey.common.request.BalanceRequest;
import ru.burlutskiysergey.common.request.CardVerifyRequest;
import ru.burlutskiysergey.common.response.BalanceResponse;
import ru.burlutskiysergey.common.response.CardVerifyResponse;

import java.util.Objects;

@RestController
@AllArgsConstructor
@Log
public class ATMRestController {
    private static final String SERVER_HOST = "http://localhost:8080";
    private static final String VERIFY_CARD_URL = SERVER_HOST + "/verifycard";
    private static final String GET_BALANCE_URL = SERVER_HOST + "/balance";

    /**
     * Запрос баланса с клиента(по номеру карты и пин-коду)
     */
    @GetMapping("/balance/cardNum/{cardNum}/pin/{pin}")
    public String getBalance(
            @PathVariable("cardNum") String cardNum,
            @PathVariable("pin") String pin) {

        log.info("cardNum " + cardNum + " PIN " + pin);

        boolean verifyResult = verifyCard(cardNum, pin);
        if (verifyResult) {
            return balance(cardNum);
        }

        throw new ATMVerifyCardException("Ошибка верификации карты");
    }

    /**
     * Верифицировать карту
     */
    private boolean verifyCard(String cardNum, String pin) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CardVerifyRequest> request = new HttpEntity<>(new CardVerifyRequest(cardNum, pin));

        log.info("verifyCard request.toString() " + request.toString());

        ResponseEntity<CardVerifyResponse> responseEntityStr = restTemplate.
                postForEntity(VERIFY_CARD_URL,
                        request, CardVerifyResponse.class);
        log.info("verifyCard responseEntityStr.getBody() " + responseEntityStr.getBody());

        return responseEntityStr.hasBody() && Objects.requireNonNull(responseEntityStr.getBody()).isResult();
    }

    /**
     * Получить баланс
     */
    private String balance(String cardNum) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BalanceRequest> request = new HttpEntity<>(new BalanceRequest().setCardNum(cardNum));

        log.info("balance request.toString() " + request.toString());

        ResponseEntity<BalanceResponse> responseEntityStr = restTemplate.
                postForEntity(GET_BALANCE_URL,
                        request, BalanceResponse.class);
        log.info("balance responseEntityStr.getBody() " + Objects.requireNonNull(responseEntityStr.getBody()).getBalance());

        if (responseEntityStr.hasBody() && !(Objects.requireNonNull(responseEntityStr.getBody()).getBalance() == null)) {
            return Objects.requireNonNull(responseEntityStr.getBody()).getBalance();
        }
        throw new ATMBalanceException("Не удалось вернуть баланс");
    }
}

