package ru.sber.javaschool;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    static Calculator calc;

    @BeforeClass
    public static void init() {
        calc = new Calculator();
    }

    @Test
    public void addition() {
        int res = calc.addition(2,5);
        Assert.assertEquals(res, 7);
    }

    @Test
    public void subtraction() {
        int res = calc.subtraction(2,5);
        Assert.assertEquals(res, -3);
    }

    @Test
    public void multiplication() {
        int res = calc.multiplication(2,5);
        Assert.assertEquals(res, 10);
    }

    @Test
    public void division() {
        double res = calc.division(2,5);
        Assert.assertEquals(res, 0.4, 0.0);
    }

    @Test
    public void pow() {
        int res = calc.pow(2,5);
        Assert.assertEquals(res, 32);
    }

    @Test
    public void mod() {
        int res = calc.mod(5,2);
        Assert.assertEquals(res, 1);
    }

    @Test
    public void sqrt() {
        double res = calc.sqrt(2);
        Assert.assertEquals(res, 1.41, 0.1);
    }
}