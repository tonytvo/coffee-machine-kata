package org.coffeemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;

    public Ingredients() {
        this.ingredientList = new ArrayList<>();
        this.inventory = new Inventory();
    }

    void updateIngredientsStockPerRecipe(Recipe recipe) {
        for (Ingredient i : getIngredientList()) {
            if (recipe.containsRecipe(i)) {
                i.setStock(i.getStock() - recipe.getQuantity(i));
            }
        }
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return getIngredientList().stream().allMatch(recipe::isMakeable);
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredientList().add(ingredient);
    }

    StringBuffer getInventory() {
        StringBuffer inventory = new StringBuffer();
        for (Ingredient i : getIngredientList()) {
            String inventoryForIngreident = i.getName() + "," + i.getStock();
            inventory.append(inventoryForIngreident).append("\n");
        }
        return inventory;
    }

    public void restockIngredients() {
        for (Ingredient i : getIngredientList()) {
            i.setStock(10);
        }
    }

    private List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    double calculateCost(Recipe recipe) {
        double currCost = 0;
        for (Ingredient i : getIngredientList()) {
            if (recipe.containsRecipe(i)) {
                currCost += i.getCost() * recipe.getQuantity(i);
            }
        }
        return currCost;
    }

    private class Inventory {
    }
}
