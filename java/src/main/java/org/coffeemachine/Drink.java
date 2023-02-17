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

    static void updateCost(Drink d, List<Ingredient> ingredientList1) {
        double currCost = d.calculateCost(ingredientList1);
        d.setCost(currCost);
    }

    void updateMakable(List<Ingredient> ingredientList1) {
        Recipe recipe = getRecipe();
        for (Ingredient i : ingredientList1) {
            boolean makeable = recipe.isMakeable(i);
            setMakeable(makeable);
            if (!makeable) {
                break;
            }
        }
    }

    double calculateCost(List<Ingredient> ingredientList1) {
        double currCost = 0;
        Recipe recipe = getRecipe();
        for (Ingredient i : ingredientList1) {
            if (recipe.containsRecipe(i)) {
                currCost += i.getCost() * recipe.getQuantity(i);
            }
        }
        return currCost;
    }

    Recipe getRecipe() {
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