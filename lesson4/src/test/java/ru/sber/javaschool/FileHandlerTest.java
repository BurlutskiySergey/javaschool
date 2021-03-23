package ru.sber.javaschool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileHandlerTest {
    char replacementSymbol;
    FileHandler fileHandler;

    @Before
    public void init() {
        replacementSymbol = '1';
        fileHandler = new FileHandler();
        fileHandler.setReplacementSymbol(replacementSymbol);
    }

    @Test
    public void checkSymbolsEquality() {
        char symbol = '1';
        Assert.assertTrue(fileHandler.checkSymbolsEquality(symbol));
    }

    @Test
    public void checkSymbolsInquality() {
        char symbol = '2';
        Assert.assertFalse(fileHandler.checkSymbolsEquality(symbol));
    }

}