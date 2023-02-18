package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

class Costs {

    private final Map<Ingredient, Double> ingredientCosts;

    public Costs() {
        ingredientCosts = new HashMap<>();
    }

    public void set(Ingredient ingredient, double cost) {
        ingredientCosts.put(ingredient, cost);
    }

    public double calculateCost(Recipe recipe) {
        double currCost = ingredientCosts.keySet().stream()
                .filter(recipe::contains)
                .mapToDouble(ingredient -> ingredient.getCost() * recipe.quantityFor(ingredient))
                .sum();
        return currCost;
    }

}
