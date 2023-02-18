package org.coffeemachine;

import java.util.*;

public class Drinks {
    private final List<Drink> drinkList;
    private final Recipes recipes;
    private final Costs costs;
    private final Inventory inventory;

    public Drinks(Costs costs, Inventory inventory, Recipes recipes) {
        this.costs = costs;
        this.inventory = inventory;
        this.drinkList = new ArrayList<>();
        this.recipes = recipes;
    }

    String getName(int drinkId) {
        return getDrink(drinkId).getName();
    }

    boolean isMakeable(int drinkId) {
        return inventory.canMake(recipes.getRecipe(getDrink(drinkId)));
    }

    boolean isValidDrinkInput(int drinkInput) {
        return drinkInput > getDrinkList().size();
    }

    void sort() {
        Collections.sort(getDrinkList());
    }

    public void addDrink(String name, String[] recipe) {
        Recipe recipeForDrink = Recipe.fromRecipeNames(recipe);
        Drink drink = new Drink(name, recipeForDrink);
        getDrinkList().add(drink);
        recipes.put(drink, recipeForDrink);
    }

    StringBuffer getDrinksMenu() {
        int count = 1;
        StringBuffer menu = new StringBuffer();
        for (Drink d : getDrinkList()) {
            menu.append(String.format("%d,%s,$%.2f," + inventory.canMake(recipes.getRecipe(d)) + "\n",
                    count,
                    d.getName(),
                    costs.calculateCost(recipes.getRecipe(d))));
            count++;
        }
        return menu;
    }

    Drink getDrink(int drinkId) {
        return getDrinkList().get(drinkId);
    }

    private List<Drink> getDrinkList() {
        return drinkList;
    }

    public void clear() {
        drinkList.clear();;
    }

}
