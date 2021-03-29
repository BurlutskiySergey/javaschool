package ru.sber.javaschool.terminal;

import lombok.Data;
import ru.sber.javaschool.card.Card;

import java.math.BigDecimal;
import java.util.Scanner;

@Data
public class TerminalImpl implements Terminal {
    /** Поле карт-ридер */
    private CardReader cardReader;

    private int requestPin() {
        System.out.println("Введите пин код...");
        Scanner scanner  = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void verify(Card card) {
        int pin;
        pin = requestPin();
        if (card.checkPin(pin)) {
            System.out.println("Верификация пройдена");
        } else {
            System.out.println("Пин код неверный. Заберите карту.");
            stop();
        }
    }

    public void start(Card card) {
        cardReader.inputCard();
        verify(card);
    }

    public void showBalance(Card card) {
        if (cardReader.checkCardAvailability()) {
            /* здесь пришлось завести в интерфейсе Card метод getBalance,
             т.к. он определяся в самом классе CardImpl(из-за авто-геттеров ломбока),
             но не определялся в интерфейсе.
             Или надо было в качестве типа параметра указывать CardImpl?
             */
            BigDecimal balance = card.getBalance();
            System.out.println("Баланс карты: " + balance);
            stop();
        } else {
            System.out.println("Вставьте карту...");
        }
    }

    public void stop() {
        cardReader.extractCard();
    }

}
