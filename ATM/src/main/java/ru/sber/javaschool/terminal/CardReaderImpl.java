package ru.sber.javaschool.terminal;

public class CardReaderImpl implements CardReader {
    /** Поле признака того, что карта вставлена в карт-ридер */
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
