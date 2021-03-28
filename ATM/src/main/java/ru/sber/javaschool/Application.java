package ru.sber.javaschool;

import ru.sber.javaschool.card.CardImpl;
import ru.sber.javaschool.terminal.CardReader;
import ru.sber.javaschool.terminal.CardReaderImpl;
import ru.sber.javaschool.terminal.TerminalImpl;
import ru.sber.javaschool.user.UserImpl;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        CardImpl card = new CardImpl();
        card.setPinCode(1234);
        card.setBalance(BigDecimal.valueOf(1000.00));
        CardReader cardReader = new CardReaderImpl();
        TerminalImpl terminal = new TerminalImpl();
        terminal.setCardReader(cardReader);
        UserImpl user = new UserImpl();
        user.setCard(card);
        user.insertCard(terminal);
        user.requestBalance(terminal);
    }
}
