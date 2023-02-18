package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private final Map<Ingredient, Integer> quantityByRecipeName;

    public Recipe(Map<Ingredient, Integer> currRecipe) {
        this.quantityByRecipeName = currRecipe;
    }

    static Recipe fromRecipeNames(String[] recipe) {
        Map<Ingredient, Integer> recipeQuantityByName = new HashMap<>();
        for (String s : recipe) {
            Ingredient ingredient = new Ingredient(s, 0);
            if (recipeQuantityByName.containsKey(ingredient)) {
                recipeQuantityByName.put(ingredient, recipeQuantityByName.get(ingredient) + 1);// increment if multiple units
            } else {
                recipeQuantityByName.put(ingredient, 1);// insert first occurrence of ingredient
            }
        }
        return new Recipe(recipeQuantityByName);
    }

    Integer getQuantity(Ingredient i) {
        return getQuantityByIngredient().get(i);
    }

    boolean contains(Ingredient i) {
        return getQuantityByIngredient().containsKey(i);
    }

    boolean isMakeable(Ingredient i) {
        return !contains(i) || i.getStock() >= getQuantityByIngredient().get(i);
    }

    private Map<Ingredient, Integer> getQuantityByIngredient() {
        return quantityByRecipeName;
    }
}
