package ru.burlutskiysergey.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.burlutskiysergey.common.dto.AccountDTO;
import ru.burlutskiysergey.common.dto.BalanceDTO;
import ru.burlutskiysergey.common.dto.CardDTO;
import ru.burlutskiysergey.server.entity.Account;
import ru.burlutskiysergey.server.entity.Card;
import ru.burlutskiysergey.server.exception.CardNotFoundException;
import ru.burlutskiysergey.server.repository.CardCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountService {
    private CardCrudRepository cardCrudRepository;

    /**
     * Получить аккаунт по номеру карты
     */
    public AccountDTO getAccount(String cardNum) {
        Card card = cardCrudRepository.findByCardNum(cardNum).orElseThrow(CardNotFoundException::new);
        Account account = card.getAccount();

        Set<Card> cardSet = account.getCards();
        List<CardDTO> cardDTOSet = new ArrayList<>();

        for (Card cardIterable : cardSet) {
            cardDTOSet.add(new CardDTO(
                    cardIterable.getId().intValue(),
                    cardIterable.getCardNum(),
                    cardIterable.getExpiredDate(),
                    cardIterable.getPin()
            ));

        }
        return new AccountDTO(
            account.getId(),
            account.getAccountNum(),
            cardDTOSet,
            new BalanceDTO(
                account.getCurrency(),
                account.getBalance()
            )
        );
    }
}
