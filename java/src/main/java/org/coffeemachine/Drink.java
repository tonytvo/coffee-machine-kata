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
        for (Ingredient i : ingredientList) {
            if (recipe.containsRecipe(i)) {
                i.setStock(i.getStock() - recipe.getQuantity(i));
            }
        }
    }

    void updateCost(List<Ingredient> ingredientList) {
        setCost(calculateCost(ingredientList));
    }

     void updateMakable(List<Ingredient> ingredientList1) {
        Recipe recipe = getRecipe();
         boolean isMakeable = isMakeable(ingredientList1, recipe);
         setMakeable(isMakeable);
    }

    private static boolean isMakeable(List<Ingredient> ingredientList1, Recipe recipe) {
        return ingredientList1.stream().allMatch(recipe::isMakeable);
    }

    private double calculateCost(List<Ingredient> ingredientList1) {
        double currCost = 0;
        Recipe recipe = getRecipe();
        for (Ingredient i : ingredientList1) {
            if (recipe.containsRecipe(i)) {
                currCost += i.getCost() * recipe.getQuantity(i);
            }
        }
        return currCost;
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