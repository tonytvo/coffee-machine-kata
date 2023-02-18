package org.coffeemachine;

class CoffeeMachine {
    private final Drinks drinks;
    private final Recipes recipes;
    private final Inventory inventory;

    CoffeeMachine(Drinks drinks, Recipes recipes, Inventory inventory) {
        this.drinks = drinks;
        this.recipes = recipes;
        this.inventory = inventory;
    }

    String getIventorySummary() {
        return inventory.summary();
    }

    void restock() {
        inventory.restock();
    }

    String getDrinksMenu() {
        return getDrinks().getDrinksMenu().toString();
    }

    boolean isValidDrinkInput(Integer number) {
        return getDrinks().isValidDrinkInput(number);
    }

    void makeDrink(int drinkId) {
        Recipe recipe = this.recipes.getRecipe(this.drinks.getDrink(drinkId));
        this.inventory.reduceFrom(recipe);
    }

    public Drinks getDrinks() {
        return drinks;
    }

}
