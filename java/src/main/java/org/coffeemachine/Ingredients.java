package org.coffeemachine;

import java.util.List;

public class Ingredients {
    private final List<Ingredient> ingredientList;

    public Ingredients(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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
