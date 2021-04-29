package ru.sber.javaschool.client;

import lombok.AllArgsConstructor;
import ru.sber.javaschool.account.Account;
import ru.sber.javaschool.balance.Balance;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Client {
    /** Поле номера клиента */
    private final int clientNum;
    /** Поле персональной информации */
    private final Person person;
    /** Коллекция счетов клиента */
    private List<Account<Balance>> accounts;

    /**
     * Метод получения информации о счёте клиента по номеру карты
     * @param cardNum - номер карты
     * @return найденный счёт
     */
    public Optional<Account<Balance>> findAccount(String cardNum) {
        return accounts.stream().filter(a -> a.findCard(cardNum) != null).findFirst();
    }

}
