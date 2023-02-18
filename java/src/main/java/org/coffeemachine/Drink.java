package org.coffeemachine;

import java.util.List;

public class Drink implements Comparable<Drink> {
    private final String name;
    private final Recipe recipe;
    private double totalCost = 0;
    private boolean makeable = false;

    public Drink(String name, String[] recipe) {
        this.name = name;
        this.recipe = Recipe.fromRecipeNames(recipe);
    }

    void make(List<Ingredient> ingredientList) {
        Recipe recipe = getRecipe();
        updateIngredientsStockPerRecipe(ingredientList, recipe);
    }

    private static void updateIngredientsStockPerRecipe(List<Ingredient> ingredientList, Recipe recipe) {
        for (Ingredient i : ingredientList) {
            if (recipe.containsRecipe(i)) {
                i.setStock(i.getStock() - recipe.getQuantity(i));
            }
        }
    }

    void updateCost(Ingredients ingredients) {
        setCost(ingredients.calculateCost(getRecipe()));
    }

     void updateMakable(Ingredients ingredients) {
        Recipe recipe = getRecipe();
         setMakeable(ingredients.isMakeable(recipe));
    }

    private Recipe getRecipe() {
        return recipe;
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public void setCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setMakeable(boolean makeable) {
        this.makeable = makeable;
    }

    public double getCost() {
        return totalCost;
    }

    public String getName() {
        return name;
    }

    public boolean getMakeable() {
        return makeable;
    }

}