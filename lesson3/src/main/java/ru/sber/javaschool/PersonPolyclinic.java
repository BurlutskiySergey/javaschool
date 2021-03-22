package ru.sber.javaschool;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PersonPolyclinic {
    private int number; //Номер
    private String Fio; // ФИО
    private int age; // Возраст
    private String sex; // Пол

    abstract String Analysis();

    abstract String WorkInfo();
}
