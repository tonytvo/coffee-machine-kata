package org.coffeemachine;

import java.util.*;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;

    public Ingredients() {
        this.ingredientList = new ArrayList<>();
        this.inventory = new Inventory();
    }

    void updateIngredientsStockPerRecipe(Recipe recipe) {
        inventory.reduceFrom(recipe);
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return inventory.canMake(recipe);
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredientList().add(ingredient);
        inventory.restock(ingredient);
    }

    String getInventory() {
        return inventory.summary();
    }

    public void restockIngredients() {
        inventory.restock();
    }

    private List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    double calculateCost(Recipe recipe) {
        double currCost = 0;
        for (Ingredient i : getIngredientList()) {
            if (recipe.contains(i)) {
                currCost += i.getCost() * recipe.quantityFor(i);
            }
        }
        return currCost;
    }

    public void clear() {
        ingredientList.clear();
    }

}
