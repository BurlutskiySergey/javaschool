package ru.sber.javaschool;

import lombok.Data;

@Data
public abstract class Doctor extends PersonPolyclinic {
    private String experience;// Стаж
    private int salary;// Зарплата
    private String category;// Категория

    public Doctor(int number, String Fio, int age, String sex,
                  String experience, int salary, String category) {
        super(number, Fio, age, sex);
        this.experience = experience;
        this.salary = salary;
        this.category = category;
    }
}
