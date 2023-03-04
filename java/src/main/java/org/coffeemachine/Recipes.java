package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

class Recipes {

    private final Map<Drink, Recipe> drinkRecipes;

    public Recipes() {
        drinkRecipes = new HashMap<>();
    }

    public void put(Drink drink, Recipe recipe) {
        drinkRecipes.put(drink, recipe);
    }

    public Recipe getRecipe(Drink drink) {
        return drinkRecipes.get(drink);
    }
}
