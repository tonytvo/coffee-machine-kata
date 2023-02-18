package org.coffeemachine;

import java.util.*;

public class Drinks {
    private final List<Drink> drinkList;
    private final Recipes recipes;

    public Drinks() {
        this.drinkList = new ArrayList<>();
        this.recipes = new Recipes();
    }

    void makeFor(Ingredients ingredients, int drinkId) {
        getDrink(drinkId).make(ingredients);
    }

    String getName(int drinkId) {
        return getDrink(drinkId).getName();
    }

    boolean isMakeable(int drinkId) {
        return getDrink(drinkId).getMakeable();
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

    public void updateCosts(Ingredients ingredients) {
        for (Drink d : getDrinkList()) {
            d.updateCost(ingredients);
        }
    }

    StringBuffer getDrinksMenu() {
        int count = 1;
        StringBuffer menu = new StringBuffer();
        for (Drink d : getDrinkList()) {
            menu.append(String.format("%d,%s,$%.2f," + d.getMakeable() + "\n", count, d.getName(), d.getCost()));
            count++;
        }
        return menu;
    }

    Drink getDrink(int drinkId) {
        return getDrinkList().get(drinkId);
    }

    public void updateMakeable(Ingredients ingredients) {
        for (Drink d : getDrinkList()) {
            d.updateMakable(ingredients);
        }
    }

    private List<Drink> getDrinkList() {
        return drinkList;
    }

    public void clear() {
        drinkList.clear();;
    }

    private static class Recipes {

        private final Map<Drink, Recipe> drinkRecipes;

        public Recipes() {
            drinkRecipes = new HashMap<>();
        }

        public void put(Drink drink, Recipe recipe) {
            drinkRecipes.put(drink, recipe);
        }
    }
}
