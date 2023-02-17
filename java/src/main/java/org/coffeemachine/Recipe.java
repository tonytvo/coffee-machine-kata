package org.coffeemachine;

import java.util.Map;

public class Recipe {
    private final Map<String, Integer> currRecipe;

    public Recipe(Map<String, Integer> currRecipe) {
        this.currRecipe = currRecipe;
    }

    boolean isMakeable(Ingredient i) {
        return !getCurrRecipe().containsKey(i.getName()) || i.getStock() >= getCurrRecipe().get(i.getName());
    }

    private Map<String, Integer> getCurrRecipe() {
        return currRecipe;
    }
}
