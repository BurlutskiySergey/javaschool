package ru.burlutskiysergey.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ru.burlutskiysergey.common.dto.AccountDTO;
import ru.burlutskiysergey.common.dto.BalanceDTO;
import ru.burlutskiysergey.common.dto.CardDTO;
import ru.burlutskiysergey.common.dto.ClientDTO;
import ru.burlutskiysergey.server.entity.Card;
import ru.burlutskiysergey.server.entity.Client;
import ru.burlutskiysergey.server.entity.Account;
import ru.burlutskiysergey.server.exception.ClientNotFoundException;
import ru.burlutskiysergey.server.repository.ClientCrudRepository;


@Service
@AllArgsConstructor
public class ClientService {
    private ClientCrudRepository clientCrudRepository;

    /**
     * Получить полные данные по клиенту
     */
    public ClientDTO getClient(Long id) {
        Client client = clientCrudRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);

        Set<Account> accountSet = client.getAccounts();
        List<AccountDTO> accountDTOSet = new ArrayList<>();

        for (Account account : accountSet) {
            Set<Card> cardSet = account.getCards();
            List<CardDTO> cardDTOSet = new ArrayList<>();

            for (Card card : cardSet) {
                cardDTOSet.add(new CardDTO(
                    card.getId().intValue(),
                    card.getCardNum(),
                    card.getExpiredDate(),
                    card.getPin()
                ));

            }

            accountDTOSet.add(new AccountDTO(
                account.getId().intValue(),
                account.getAccountNum(),
                cardDTOSet,
                new BalanceDTO(
                    account.getCurrency(),
                    account.getBalance()
                )
            ));
        }

        return new ClientDTO(client.getId().intValue(),
                client.getClientNum(),
                client.getLastName() + " " + client.getFirstName() + " " + client.getMiddleName(),
                client.getAge(),
                accountDTOSet);
    }
}
