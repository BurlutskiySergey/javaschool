package ru.sber.javaschool;

import lombok.Data;

@Data
public class Surgeon extends Doctor {
    private int numberOfOperations; // Количество операций

    public Surgeon(int number, String Fio, int age, String sex,
                   String experience, int salary, String category,
                   int numberOfOperations) {
        super(number, Fio, age, sex, experience, salary, category);
        this.numberOfOperations = numberOfOperations;
    }

    @Override
    public String Analysis() {
        return "Хирург: " + "№" + getNumber()+ " " + getFio() + " велел лечь на операцию";
    }

    @Override
    public String WorkInfo() {
        return "Хирург много работал, сделал " + getNumberOfOperations() + " операций";
    }

}