package org.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    public static void main(String[] args) {
        Drinks drinks = Model.drinks;
        Ingredients ingredients = Model.ingredients;
        Model.initModel(drinks, ingredients);
        CliView cliView = new CliView();
        cliView.askForSelection(drinks, ingredients);
        startIO(cliView, drinks, ingredients);
    }

    public static void startIO(CliView cliView, Drinks drinks, Ingredients ingredients) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (true) {
            try {
                input = reader.readLine().toLowerCase();

                if (input.equals("")) {
                    continue;
                }
                if (input.equals("q")) {
                    break;
                }
                if (input.equals("r")) {
                    ingredients.restockIngredients();
                } else {
                    int drinkId = parseDrinkIdAndThrowExceptionIfInvalid(input, drinks);
                    Model.makeDrink(drinks.getDrink(drinkId), cliView, ingredients);
                }
                drinks.updateMakeable(ingredients);
                cliView.askForSelection(drinks, ingredients);
            } catch (Exception e) {
                cliView.displayInvalidSelection(input);
            }
        }
    }

    private static int parseDrinkIdAndThrowExceptionIfInvalid(String input, Drinks drinks) throws IOException {
        int drinkInput = Integer.parseInt(input);
        if (drinkInput <= 0 || drinks.isValidDrinkInput(drinkInput)) {
            throw new IOException(); // legal, but invalid input
        }
        return drinkInput - 1;
    }

}