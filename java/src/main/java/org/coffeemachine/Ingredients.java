package org.coffeemachine;

import java.util.*;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;
    private final Costs costs;

    public Ingredients(Costs costs1, Inventory inventory) {
        this.ingredientList = new ArrayList<>();
        this.inventory = inventory;
        this.costs = costs1;
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return inventory.canMake(recipe);
    }

    public void addIngredient(Ingredient ingredient, double cost) {
        getIngredientList().add(ingredient);
        inventory.restock(ingredient);
        costs.set(ingredient, cost);
    }

    String getInventory() {
        return inventory.summary();
    }

    private List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    double calculateCost(Recipe recipe) {
        return costs.calculateCost(recipe);
    }

    public void clear() {
        ingredientList.clear();
    }

}
