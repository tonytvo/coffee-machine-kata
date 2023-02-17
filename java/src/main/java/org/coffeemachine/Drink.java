package org.coffeemachine;

public class Drink implements Comparable<Drink> {
    private final String name;
    private final Recipe recipe;
    private double totalCost = 0;
    private boolean makeable = false;

    public Drink(String name, String[] recipe) {
        this.name = name;
        this.recipe = Recipe.fromRecipeNames(recipe);
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