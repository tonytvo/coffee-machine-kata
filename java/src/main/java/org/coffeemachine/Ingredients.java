package org.coffeemachine;

import java.util.List;

public class Ingredients {
    private final List<Ingredient> ingredientList;

    public Ingredients(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
