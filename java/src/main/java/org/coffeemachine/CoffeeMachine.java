package org.coffeemachine;

public class CoffeeMachine {

    public static void main(String[] args) {
        Drinks drinks = new Drinks();
        Ingredients ingredients = new Ingredients();
        Costs costs = new Costs();
        Model.initModel(drinks, ingredients, costs);
        CliView cliView = new CliView(() -> System.out);
        new Controller().start(cliView, drinks, ingredients, () -> System.in);
    }

}