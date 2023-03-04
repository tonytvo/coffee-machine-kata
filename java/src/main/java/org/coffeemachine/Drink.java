package org.coffeemachine;

import java.util.Objects;

public class Drink implements Comparable<Drink> {
    private final String name;

    public Drink(String name) {
        this.name = name;
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return name.equals(drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}