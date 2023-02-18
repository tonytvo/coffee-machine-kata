package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private final Map<String, Integer> quantityByRecipeName;

    public Recipe(Map<String, Integer> currRecipe) {
        this.quantityByRecipeName = currRecipe;
    }

    static Recipe fromRecipeNames(String[] recipe) {
        Map<String, Integer> recipeQuantityByName = new HashMap<>();
        for (String s : recipe) {
            if (recipeQuantityByName.containsKey(s)) {
                recipeQuantityByName.put(s, recipeQuantityByName.get(s) + 1);// increment if multiple units
            } else {
                recipeQuantityByName.put(s, 1);// insert first occurrence of ingredient
            }
        }
        return new Recipe(recipeQuantityByName);
    }

    Integer getQuantity(Ingredient i) {
        return getQuantityByRecipeName().get(i.getName());
    }

    boolean contains(Ingredient i) {
        return getQuantityByRecipeName().containsKey(i.getName());
    }

    boolean isMakeable(Ingredient i) {
        return !contains(i) || i.getStock() >= getQuantityByRecipeName().get(i.getName());
    }

    private Map<String, Integer> getQuantityByRecipeName() {
        return quantityByRecipeName;
    }
}
