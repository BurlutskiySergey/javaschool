package ru.sber.javaschool;

import lombok.Data;

@Data
public class Therapist extends Doctor {
    private int numberOfVisits; // Количество посещений

    public Therapist(int number, String Fio, int age, String sex,
                   String experience, int salary, String category,
                   int numberOfVisits) {
        super(number, Fio, age, sex, experience, salary, category);
        this.numberOfVisits = numberOfVisits;
    }


    @Override
    public String Analysis() {
        return "Терапевт: " + "№" + getNumber() + " " + getFio() + " велел сдать анализ крови.";
    }

    @Override
    public String WorkInfo() {
        return "Терапевт много работал, принял " + getNumberOfVisits() + " посещений";
    }
}