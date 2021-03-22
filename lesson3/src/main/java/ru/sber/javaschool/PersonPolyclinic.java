package ru.sber.javaschool;

@Data
public abstract class PersonPolyclinic {
    private String Fio;// ФИО
    private int age;// Возраст
    private String sex;// Пол

    public String Analysis() {
        return "Доктор" + getFio() + " велел сдать анализ:" + "  ";
    }
}
