package ru.sber.javaschool;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.replaceSymbolInFile('1');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
