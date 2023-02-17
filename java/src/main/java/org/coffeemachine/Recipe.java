package org.coffeemachine;

import java.util.Map;

public class Recipe {
    private final Map<String, Integer> currRecipe;

    public Recipe(Map<String, Integer> currRecipe) {
        this.currRecipe = currRecipe;
    }

    static boolean isMakeable(Recipe recipe, Ingredient i) {
        return !recipe.getCurrRecipe().containsKey(i.getName()) || i.getStock() >= recipe.getCurrRecipe().get(i.getName());
    }

    public Map<String, Integer> getCurrRecipe() {
        return currRecipe;
    }
}
