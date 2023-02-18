package org.coffeemachine;

public class CoffeeMachine {

    public static void main(String[] args) {
        Costs costs = new Costs();
        Drinks drinks = new Drinks(costs);
        Ingredients ingredients = new Ingredients(costs);
        Model.initModel(drinks, ingredients, costs);
        CliView cliView = new CliView(() -> System.out);
        new Controller().start(cliView, drinks, ingredients, () -> System.in);
    }

}