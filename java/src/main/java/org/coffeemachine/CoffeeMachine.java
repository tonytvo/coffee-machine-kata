package org.coffeemachine;

public class CoffeeMachine {

    public static void main(String[] args) {
        Costs costs = new Costs();
        Inventory inventory = new Inventory();
        Recipes recipes = new Recipes();
        Drinks drinks = new Drinks(costs, inventory, recipes);
        Ingredients ingredients = new Ingredients(costs, inventory);
        Model.initModel(drinks, ingredients, costs);
        CliView cliView = new CliView(() -> System.out);
        new Controller().start(cliView,
                drinks,
                recipes,
                inventory,
                () -> System.in);
    }

}