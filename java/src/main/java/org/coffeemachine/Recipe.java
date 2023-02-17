package org.coffeemachine;

import java.util.Map;

public class Recipe {
    private final Map<String, Integer> currRecipe;

    public Recipe(Map<String, Integer> currRecipe) {
        this.currRecipe = currRecipe;
    }

    Integer getQuantity(Ingredient i) {
        return getCurrRecipe().get(i.getName());
    }

    boolean containsReceipt(Ingredient i) {
        return getCurrRecipe().containsKey(i.getName());
    }

    boolean isMakeable(Ingredient i) {
        return !getCurrRecipe().containsKey(i.getName()) || i.getStock() >= getCurrRecipe().get(i.getName());
    }

    public Map<String, Integer> getCurrRecipe() {
        return currRecipe;
    }
}
