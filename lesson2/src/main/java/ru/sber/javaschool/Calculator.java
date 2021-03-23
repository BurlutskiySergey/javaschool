package ru.sber.javaschool;

public class Calculator {
    /* Сложение */
    public int addition(int num1, int num2) {
        return num1+num2;
    }

    /* Вычитание */
    public int subtraction(int num1, int num2) {
        return num1-num2;
    }

    /* Умножение */
    public int multiplication(int num1, int num2) {
        return num1*num2;
    }

    /* Деление */
    public double division(int num1, int num2) {
        return (double)num1/num2;
    }

    /* Возведение в степень */
    public int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    /* Целочисленный остаток от деления */
    public int mod(int num1, int num2) {
        return num1%num2;
    }

    /* Квадратный корень */
    public double sqrt(int value) {
        double num;
        double half = (double) value / 2;
        do {
            num = half;
            half = (num + (value / num)) / 2;
        } while ((num - half) != 0);
        return half;
    }
}