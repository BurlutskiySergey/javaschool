package ru.sber.javaschool;

@Data
public class Therapist extends Doctor {
    private int numberTherapist;// Номер терапевта
    private String degree;// Ученая степень
    private String workingHours;// Рабочее время

    @Override
    public String Analysis() {
        return "Терапевт: " + "номер-" + getNumberTherapist() + " " + getFio() + " велел сдать анализ:" + " Кала.";
    }
}