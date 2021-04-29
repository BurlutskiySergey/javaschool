package ru.sber.javaschool.terminal;

import lombok.AllArgsConstructor;
import ru.sber.javaschool.account.Account;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.processing.Processing;
import ru.sber.javaschool.processing.ProcessingException;

import java.util.Scanner;

@AllArgsConstructor
public class ATM implements Terminal {
    /** Поле карт-ридер */
    private CardReader cardReader;
    /** Поле процессинг */
    private Processing processing;

    private int requestPin() {
        System.out.println("Введите пин код...");
        Scanner scanner  = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void verify(Card card) {
        int pin;
        pin = requestPin();
        try {
            processing.checkPinCode(card.getPinCode(), pin);
        } catch (ProcessingException e) {
            System.out.println(e.getMessage());
            stop();
        }
    }

    public void start(Card card) {
        cardReader.inputCard();
        verify(card);
    }

    public void showBalance(Card card) {
        if (cardReader.checkCardAvailability()) {
            try {
                processing.checkCardData(card.getCardNum(), card.getPinCode());
                Account<?> account = processing.getAccountData(card.getCardNum());

                System.out.println("Баланс счёта №: " + account.getAccountNum() +
                        " составляет " + account.getBalance().getAmount() +
                        "  " + account.getBalance().getCurrency()
                );
                stop();
            } catch (ProcessingException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Вставьте карту...");
        }
    }

    public void stop() {
        cardReader.extractCard();
    }

}
