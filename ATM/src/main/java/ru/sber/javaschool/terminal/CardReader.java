package ru.sber.javaschool.terminal;

public interface CardReader {
    void inputCard();
    void extractCard();
    boolean checkCardAvailability();
}
