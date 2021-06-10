package ru.burlutskiysergey.javaschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.burlutskiysergey.javaschool.card.BankCard;
import ru.burlutskiysergey.javaschool.card.Card;
import ru.burlutskiysergey.javaschool.terminal.ATM;
import ru.burlutskiysergey.javaschool.terminal.ATMCardReader;
import ru.burlutskiysergey.javaschool.terminal.CardReader;
import ru.burlutskiysergey.javaschool.terminal.Terminal;
import ru.burlutskiysergey.javaschool.user.CustomUser;
import ru.burlutskiysergey.javaschool.user.User;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
/*        Card card = new BankCard();
        card.setPinCode(1234);
        card.setBalance(BigDecimal.valueOf(1000.00));
        CardReader cardReader = new ATMCardReader();
        Terminal ATM = new ATM();
        ATM.setCardReader(cardReader);
        User user = new CustomUser();
        user.setCard(card);
        user.insertCard(ATM);
        user.requestBalance(ATM);*/
    }
}
