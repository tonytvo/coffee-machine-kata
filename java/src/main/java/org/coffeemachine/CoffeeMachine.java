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

    static String getDrinksMenu(CoffeeMachine coffeeMachine) {
        return coffeeMachine.getDrinks().getDrinksMenu().toString();
    }

    void makeDrink(int drinkId) {
        Recipe recipe = this.recipes.getRecipe(this.drinks.getDrink(drinkId));
        this.inventory.reduceFrom(recipe);
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
