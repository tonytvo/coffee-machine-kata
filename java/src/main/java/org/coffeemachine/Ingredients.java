package org.coffeemachine;

import java.util.*;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;
    private final Costs costs;

    public Ingredients() {
        this.ingredientList = new ArrayList<>();
        this.inventory = new Inventory();
        this.costs = new Costs();
    }

    void updateIngredientsStockPerRecipe(Recipe recipe) {
        inventory.reduceFrom(recipe);
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return inventory.canMake(recipe);
    }

    public void addIngredient(Ingredient ingredient, double cost) {
        getIngredientList().add(ingredient);
        inventory.restock(ingredient);
        costs.set(ingredient, cost);
    }

    String getInventory() {
        return inventory.summary();
    }

    public void restockIngredients() {
        inventory.restock();
    }

    private List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    double calculateCost(Recipe recipe) {
        double currCost = 0;
        for (Ingredient i : getIngredientList()) {
            if (recipe.contains(i)) {
                currCost += i.getCost() * recipe.quantityFor(i);
            }
        }
        return currCost;
    }

    public void clear() {
        ingredientList.clear();
    }

    private static class Costs {

        private final Map<Ingredient, Double> ingredientCosts;

        public Costs() {
            ingredientCosts = new HashMap<>();
        }

        public void set(Ingredient ingredient, double cost) {
            ingredientCosts.put(ingredient, cost);
        }
    }
}
