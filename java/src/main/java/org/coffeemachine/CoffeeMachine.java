package org.coffeemachine;

public class CoffeeMachine {

    public static void main(String[] args) {
        Drinks drinks = Model.drinks;
        Ingredients ingredients = Model.ingredients;
        Model.initModel(drinks, ingredients);
        CliView cliView = new CliView(() -> System.out);
        Controller.startIO(cliView, drinks, ingredients, () -> System.in);
    }

}