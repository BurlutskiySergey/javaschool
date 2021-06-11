package ru.burlutskiysergey.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

@Getter
@ToString
@AllArgsConstructor
public enum Currency {
    RUB("RUR"),
    USD("USD"),
    EUR("EUR");

    private String name;

    public static Currency getType(String name) {
        if (name == null) {
            return null;
        }

        return EnumSet.allOf(Currency.class).stream().filter(cur -> name.equals(cur.getName()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No matching type for currency " + name));
    }
}
