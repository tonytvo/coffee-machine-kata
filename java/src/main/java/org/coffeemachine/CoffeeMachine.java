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

    boolean canMakeDrink(int drinkId) {
        return drinks.isMakeable(drinkId);
    }

    String getNameForDrink(int drinkId) {
        return drinks.getName(drinkId);
    }

    String getIventorySummary() {
        return inventory.summary();
    }

    void restock() {
        inventory.restock();
    }

    String getDrinksMenu() {
        return drinks.getDrinksMenu().toString();
    }

    boolean isValidDrinkInput(Integer number) {
        return drinks.isValidDrinkInput(number);
    }

    void makeDrink(int drinkId) {
        Recipe recipe = this.recipes.getRecipe(this.drinks.getDrink(drinkId));
        this.inventory.reduceFrom(recipe);
    }

}
