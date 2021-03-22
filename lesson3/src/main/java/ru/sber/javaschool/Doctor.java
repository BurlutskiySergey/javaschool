package ru.sber.javaschool;

@Data
public abstract class Doctor extends PersonPolyclinic {
    private String experience;// Стаж
    private int salary;// Зарплата
    private String category;// Категория
}
