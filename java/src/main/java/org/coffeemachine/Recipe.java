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
            Ingredient ingredient = new Ingredient(s);
            if (recipeQuantityByName.containsKey(ingredient)) {
                recipeQuantityByName.put(ingredient, recipeQuantityByName.get(ingredient) + 1);// increment if multiple units
            } else {
                recipeQuantityByName.put(ingredient, 1);// insert first occurrence of ingredient
            }
        }
        return new Recipe(recipeQuantityByName);
    }

    Integer quantityFor(Ingredient i) {
        if (!getQuantityByIngredient().containsKey(i)) return  0;
        return getQuantityByIngredient().get(i);
    }

    boolean contains(Ingredient i) {
        return getQuantityByIngredient().containsKey(i);
    }

    private Map<Ingredient, Integer> getQuantityByIngredient() {
        return quantityByRecipeName;
    }
}
