package org.coffeemachine;

import java.util.Objects;

public class Ingredient implements Comparable<Ingredient> {
    private final String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public int compareTo(Ingredient ingredient) {
        return name.compareTo(ingredient.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}