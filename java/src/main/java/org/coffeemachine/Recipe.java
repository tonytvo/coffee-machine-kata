package org.coffeemachine;

import java.util.Map;

public class Recipe {
    private final Map<String, Integer> currRecipe;

    public Recipe(Map<String, Integer> currRecipe) {
        this.currRecipe = currRecipe;
    }

    public Map<String, Integer> getCurrRecipe() {
        return currRecipe;
    }
}
