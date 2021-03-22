package ru.sber.javaschool;

@Data
public class Surgeon extends Doctor {
    private int numbeSurgeon;// Номер хирурга
    private String specialization;// Специализация
    private int kolOperations;// Количество операций

    @Override
    public String Analysis() {
        return "Хирург: " + "номер-" + getNumbeSurgeon()+ " " + getFio() + " велел сдать анализ:" + " Крови, мочи.";
    }

}