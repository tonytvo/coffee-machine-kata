package org.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class CoffeeMachine {

    public static void main(String[] args) {
        Drinks drinks = Model.drinks;
        Ingredients ingredients = Model.ingredients;
        Model.initModel(drinks, ingredients);
        CliView cliView = new CliView(() -> System.out);
        startIO(cliView, drinks, ingredients, () -> System.in);
    }

    public static void startIO(CliView cliView,
                               Drinks drinks,
                               Ingredients ingredients,
                               Supplier<InputStream> inputStreamSupplier) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamSupplier.get()));
        String input = "";

        cliView.askForSelection(drinks, ingredients);
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