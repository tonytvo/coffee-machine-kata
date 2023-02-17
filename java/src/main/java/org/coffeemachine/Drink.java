package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Drink implements Comparable<Drink> {
    private final Map<String, Integer> recipe = new HashMap<>();// map ingredients to units per
    private final String name;
    private double totalCost = 0;
    private boolean makeable = false;

    public Drink(String name, String[] recipe) {
        this.name = name;
        setRecipe(recipe);
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public void setRecipe(String[] recipe) {
        for (String s : recipe) {
            if (this.recipe.containsKey(s)) {
                this.recipe.put(s, this.recipe.get(s) + 1);// increment if multiple units
            } else {
                this.recipe.put(s, 1);// insert first occurrence of ingredient
            }
        }
    }

    public void setCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setMakeable(boolean makeable) {
        this.makeable = makeable;
    }

    public Map<String, Integer> getRecipe() {
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