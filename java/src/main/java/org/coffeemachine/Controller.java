package org.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class Controller {

    private static int parseDrinkIdAndThrowExceptionIfInvalid(String input, Drinks drinks) throws IOException {
        int drinkInput = Integer.parseInt(input);
        if (drinkInput <= 0 || drinks.isValidDrinkInput(drinkInput)) {
            throw new IOException(); // legal, but invalid input
        }
        return drinkInput - 1;
    }

    public void start(CliView cliView,
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
                    Drink drink = drinks.getDrink(drinkId);
                    if (drink.getMakeable()) {
                        cliView.displayDispensingDrink(drink.getName());
                        drink.make(ingredients);
                    } else {
                        cliView.displayOutOfStock(drink.getName());
                    }
                }
                drinks.updateMakeable(ingredients);
                cliView.askForSelection(drinks, ingredients);
            } catch (Exception e) {
                cliView.displayInvalidSelection(input);
            }
        }
    }
}
