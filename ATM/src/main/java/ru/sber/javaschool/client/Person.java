package ru.sber.javaschool.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    /** Поле имени */
    private String firstName;
    /** Поле отчества */
    private String middleName;
    /** Поле фамилии */
    private String lastName;
    /** Поле возраста */
    private int age;
}
