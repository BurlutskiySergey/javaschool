package ru.sber.javaschool;

public class Application {
    public static void main(String[] args) {
        PersonPolyclinic pt1 = new Patient(55, "Носов Николай Петрович", 34, "мужской", 486469, "ОРВИ");
        PersonPolyclinic pt2 = new Patient(44, "Кротов Михаил Николаевич", 25, "мужской", 645566, "Бронхит");
        PersonPolyclinic pt3 = new Patient(23, "Горбунов Вадим Юрьевич", 28, "мужской", 373865, "Аритмия");
        PersonPolyclinic pt4 = new Patient(56, "Цветкова Мария Викторовна", 33, "женский", 743820, "Астигматизм");

        PersonPolyclinic su1 = new Surgeon(365, "Машков Дмитрий Александрович", 43, "мужской", "60000 р.", "Высшая", "Офтальмолог", 74, "15 лет");
        PersonPolyclinic su2 = new Surgeon(153, "Болтунов Александр Михайлович", 47, "мужской", "70000 р.", "Высшая", "Кардиохирург", 90, "20 лет");
        PersonPolyclinic su3 = new Surgeon(047, "Рябинин Геннадий Романович", 36, "мужской", "80000 р.", "Вторая", "Нейрохирург", 34, "10 лет");

        PersonPolyclinic the1 = new Therapist(268, "Огурцов Михаил Дмитрович", 53, "мужской", "50000 р.", "Высшая", "25 лет", "Доктор наук", "с 9:00 до 13:00");
        PersonPolyclinic the2 = new Therapist(169, "Маркова Марина Алексеевна", 26, "женский", "30000 р.", "Вторая", "3 лет", "Кандидат наук", "с 12:00 до 15:00");
        PersonPolyclinic the3 = new Therapist(361, "Булыгина Екатерина Петровна", 35, "женский", "30000 р.", "Первая", "10 лет", "Кандидат наук", "с 8:00 до 12:00");

        System.out.println(su1.Analysis());
    }
}
