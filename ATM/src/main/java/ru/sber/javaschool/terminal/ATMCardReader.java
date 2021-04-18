package ru.sber.javaschool.terminal;

public class ATMCardReader implements CardReader {
    private boolean isCardInserted = false;

    @Override
    public void inputCard() {
        isCardInserted = true;
    }

    @Override
    public void extractCard() {
        isCardInserted = false;
    }

    @Override
    public boolean checkCardAvailability() {
        return isCardInserted;
    }
}
