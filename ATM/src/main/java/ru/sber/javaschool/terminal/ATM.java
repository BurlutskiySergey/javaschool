package ru.sber.javaschool.terminal;

import lombok.AllArgsConstructor;
import ru.sber.javaschool.account.Account;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.processing.Processing;
import ru.sber.javaschool.processing.ProcessingException;
import ru.sber.javaschool.terminal.devices.Display;
import ru.sber.javaschool.terminal.devices.Keyboard;
import ru.sber.javaschool.terminal.devices.cardreader.CardReader;

@AllArgsConstructor
public class ATM implements Terminal {
    /** Поле карт-ридер */
    private CardReader cardReader;
    /** Поле процессинг */
    private Processing processing;
    /** Поле дисплей */
    private Display display;
    /** Поле клавиатура */
    private Keyboard keyboard;

    @Override
    public void start(Card card) {
        cardReader.inputCard();
        verify(card);
    }

    @Override
    public void showBalance(Card card) {
        if (cardReader.checkCardAvailability()) {
            try {
                processing.checkCardData(card.getCardNum(), card.getPinCode());
                Account<?> account = processing.getAccountData(card.getCardNum());
                display.showMessage("Баланс счёта №: " + account.getAccountNum() +
                    " составляет " + account.getBalance().getAmount() +
                    "  " + account.getBalance().getCurrency()
                );
                stop();
            } catch (ProcessingException e) {
                display.showErrorMessage(e.getMessage());
            }
        } else {
            display.showMessage("Вставьте карту...");
        }
    }

    @Override
    public void stop() {
        cardReader.extractCard();
    }

    /**
     * Вирификация вставляемой карты
     * @param card - карта
     */
    private void verify(Card card) {
        int pin = keyboard.getInputInt();
        try {
            processing.checkPinCode(card.getPinCode(), pin);
        } catch (ProcessingException e) {
            display.showErrorMessage(e.getMessage());
            stop();
        }
    }
}
