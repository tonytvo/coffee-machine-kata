package org.coffeemachine;

public class CoffeeMachine {

    public static void main(String[] args) {
        Drinks drinks = new Drinks();
        Costs costs = new Costs();
        Ingredients ingredients = new Ingredients(costs);
        Model.initModel(drinks, ingredients, costs);
        CliView cliView = new CliView(() -> System.out);
        new Controller().start(cliView, drinks, ingredients, () -> System.in);
    }

}