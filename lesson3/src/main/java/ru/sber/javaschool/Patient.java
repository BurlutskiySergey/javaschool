package ru.sber.javaschool;

@Data
public class Patient extends PersonPolyclinic {
    private int numberPatient;// Номер пациента
    private int numberCard;// Номер карточки клиента
    private String diagnosis;// Диагноз
}