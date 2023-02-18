package org.coffeemachine;

import java.util.Objects;

public class Drink implements Comparable<Drink> {
    private final String name;
    private final Recipe recipe;
    private boolean makeable = false;

    public Drink(String name, Recipe recipe1) {
        this.name = name;
        this.recipe = recipe1;
    }

    void make(Ingredients ingredients) {
        Recipe recipe = getRecipe();
        ingredients.updateIngredientsStockPerRecipe(recipe);
    }

    void updateMakable(Ingredients ingredients) {
        Recipe recipe = getRecipe();
         setMakeable(ingredients.isMakeable(recipe));
    }

    private Recipe getRecipe() {
        return recipe;
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public void setMakeable(boolean makeable) {
        this.makeable = makeable;
    }

    public String getName() {
        return name;
    }

    public boolean getMakeable() {
        return makeable;
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