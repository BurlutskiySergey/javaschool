package ru.sber.javaschool.client;

import ru.sber.javaschool.account.Account;

import java.util.List;

public class Client {
    /** Поле номера клиента */
    private int clientNum;
    /** Поле персональной информации */
    private Person person;
    /** Коллекция счетов клиента */
    private List<Account<?>> accounts;
}
