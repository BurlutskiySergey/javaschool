package ru.sber.javaschool;

import ru.sber.javaschool.account.Account;
import ru.sber.javaschool.balance.Balance;
import ru.sber.javaschool.balance.BalanceNotOverdraft;
import ru.sber.javaschool.balance.Currency;
import ru.sber.javaschool.card.BankCard;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.client.Client;
import ru.sber.javaschool.client.Person;
import ru.sber.javaschool.processing.Processing;
import ru.sber.javaschool.terminal.ATM;
import ru.sber.javaschool.terminal.devices.Display;
import ru.sber.javaschool.terminal.devices.Keyboard;
import ru.sber.javaschool.terminal.devices.cardreader.ATMCardReader;
import ru.sber.javaschool.terminal.Terminal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        Card clientBankCard = new BankCard(123, "1234567890123456", LocalDate.of(2022, 1, 1));
        cards.add(clientBankCard);
        List<Account<Balance>> accounts = new ArrayList<>();
        accounts.add(new Account<>("1", new BalanceNotOverdraft(Currency.RUR, BigDecimal.valueOf(1000)), cards));
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, new Person("Павел", "Иванович", "Сидоров", 69), accounts));
        Terminal ATM = new ATM(new ATMCardReader(), new Processing(clients), new Display(), new Keyboard());
        ATM.start(clientBankCard);
        ATM.showBalance(clientBankCard);
    }
}
