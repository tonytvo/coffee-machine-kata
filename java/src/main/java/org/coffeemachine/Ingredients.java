package org.coffeemachine;

import java.util.List;

public class Ingredients {
    private final List<Ingredient> ingredientList;

    public Ingredients(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public static void restockIngredients(Ingredients ingredients) {
        for (Ingredient i : ingredients.getIngredientList()) {
            i.setStock(10);
        }
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
