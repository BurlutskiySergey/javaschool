package ru.burlutskiysergey.server.client;

import ru.burlutskiysergey.server.account.Account;

import java.util.List;

public class Client {
    /** Поле номера клиента */
    private int clientNum;
    /** Поле персональной информации */
    private Person person;
    /** Коллекция счетов клиента */
    private List<Account<?>> accounts;
}
