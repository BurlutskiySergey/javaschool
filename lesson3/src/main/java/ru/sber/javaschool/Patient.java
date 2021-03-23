package ru.sber.javaschool;

import lombok.Data;

@Data
public class Patient extends PersonPolyclinic {
    private int numberCard;// Номер карточки клиента
    private String diagnosis;// Диагноз

    public Patient(int number, String Fio, int age, String sex, int numberCard, String diagnosis) {
        super(number, Fio, age, sex);
        this.numberCard = numberCard;
        this.diagnosis = diagnosis;
    }

    @Override
    String Analysis() {
        return "У пациента № " + getNumber() + getFio() + " диагноз " + getDiagnosis() + ". Номер карточки: " + getNumberCard();
    };

    @Override
    String WorkInfo() {
        return "Пациент не работает, пациент ест";
    };
}