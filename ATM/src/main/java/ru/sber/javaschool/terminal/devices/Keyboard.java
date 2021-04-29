package ru.sber.javaschool.terminal.devices;

import java.util.Scanner;

public class Keyboard {
    /**
     * Получить данные введенные с клавиатуры
     */
    public String getInputData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Получить числовые данные введенные с клавиатуры
     */
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
