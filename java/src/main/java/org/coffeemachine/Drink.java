package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Drink implements Comparable<Drink> {
    private final Map<String, Integer> recipe = new HashMap<>();// map ingredients to units per
    private final String name;
    private final Recipe recipeTemp;
    private double totalCost = 0;
    private boolean makeable = false;

    public Drink(String name, String[] recipe) {
        this.name = name;
        this.recipeTemp = convertToRecipe(recipe);
    }

    private static Recipe convertToRecipe(String[] recipe) {
        Map<String, Integer> recipeQuantityByName = new HashMap<>();
        for (String s : recipe) {
            if (recipeQuantityByName.containsKey(s)) {
                recipeQuantityByName.put(s, recipeQuantityByName.get(s) + 1);// increment if multiple units
            } else {
                recipeQuantityByName.put(s, 1);// insert first occurrence of ingredient
            }
        }
        return new Recipe(recipeQuantityByName);
    }

    Recipe getRecipeTemp() {
        Map<String, Integer> currRecipe = getRecipe();
        return recipeTemp;
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

    private Map<String, Integer> getRecipe() {
        return recipe;
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