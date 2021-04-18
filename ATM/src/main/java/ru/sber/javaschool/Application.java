package ru.sber.javaschool;

import ru.sber.javaschool.card.BankCard;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.terminal.ATM;
import ru.sber.javaschool.terminal.ATMCardReader;
import ru.sber.javaschool.terminal.CardReader;
import ru.sber.javaschool.terminal.Terminal;
import ru.sber.javaschool.user.CustomUser;
import ru.sber.javaschool.user.User;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Card card = new BankCard();
        card.setPinCode(1234);
        card.setBalance(BigDecimal.valueOf(1000.00));
        CardReader cardReader = new ATMCardReader();
        Terminal ATM = new ATM();
        ATM.setCardReader(cardReader);
        User user = new CustomUser();
        user.setCard(card);
        user.insertCard(ATM);
        user.requestBalance(ATM);
    }
}
