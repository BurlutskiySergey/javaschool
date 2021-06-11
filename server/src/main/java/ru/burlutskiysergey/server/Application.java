package ru.burlutskiysergey.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
