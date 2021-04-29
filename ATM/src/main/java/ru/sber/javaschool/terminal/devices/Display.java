package ru.sber.javaschool.terminal.devices;

import static java.lang.System.out;

public class Display {
    /**
     * Отобразить сообщение
     * @param message - сообщение
     */
    public void showMessage(String message) {
        out.println(message);
    }

    /**
     * Отобразить сообщение об ошибке
     * @param errorMessage - сообщение об ошибке
     */
    public void showErrorMessage(String errorMessage) {
        out.println(errorMessage);
    }
}
