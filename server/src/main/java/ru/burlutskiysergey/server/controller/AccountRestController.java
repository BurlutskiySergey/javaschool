package ru.burlutskiysergey.server.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.burlutskiysergey.common.dto.AccountDTO;
import ru.burlutskiysergey.common.request.BalanceRequest;
import ru.burlutskiysergey.common.response.BalanceResponse;
import ru.burlutskiysergey.server.service.AccountService;

@RestController
@AllArgsConstructor
@Log
public class AccountRestController {
    private AccountService accountService;

    /**
     * Запрос баланса
     */
    @PostMapping(value = "/balance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BalanceResponse getBalance(@RequestBody BalanceRequest balanceRequest) {
        log.info("Запрос на получение данных по балансу. cardNum: " + balanceRequest.getCardNum());

        AccountDTO accountDTO = accountService.getAccount(balanceRequest.getCardNum());
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(accountDTO.getBalanceDTO().getBalance().toString() + " " + accountDTO.getBalanceDTO().getCurrency());
        return balanceResponse;
    }
}
