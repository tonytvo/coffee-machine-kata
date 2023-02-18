package org.coffeemachine;

import java.util.List;

public class Ingredients {
    private final List<Ingredient> ingredientList;

    public Ingredients(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    static StringBuffer getInventory(Ingredients ingredients) {
        StringBuffer inventory = new StringBuffer();
        for (Ingredient i : ingredients.getIngredientList()) {
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
