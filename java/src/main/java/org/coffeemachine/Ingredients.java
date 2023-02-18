package org.coffeemachine;

import java.util.*;

public class Ingredients {
    private final Inventory inventory;
    private final Costs costs;

    public Ingredients(Costs costs1, Inventory inventory) {
        this.inventory = inventory;
        this.costs = costs1;
    }

    public void addIngredient(Ingredient ingredient, double cost) {
        inventory.restock(ingredient);
        costs.set(ingredient, cost);
    }

}
