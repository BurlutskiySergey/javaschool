package ru.sber.javaschool;

public class Application {
    public static void main(String[] args) {
        PersonPolyclinic pt = new Patient(55, "Носов Николай Петрович", 34, "мужской", 486469, "ОРВИ");
        PersonPolyclinic su = new Surgeon(365, "Машков Дмитрий Александрович", 43, "мужской", "10 лет", 100000, "Высшая", 74);
        PersonPolyclinic the = new Therapist(268, "Огурцов Михаил Дмитрович", 53, "мужской", "10 лет", 2000, "Высшая", 35);

        System.out.println(pt.Analysis());
        System.out.println(pt.WorkInfo());
        System.out.println(su.Analysis());
        System.out.println(su.WorkInfo());
        System.out.println(the.Analysis());
        System.out.println(the.WorkInfo());

    }
}
