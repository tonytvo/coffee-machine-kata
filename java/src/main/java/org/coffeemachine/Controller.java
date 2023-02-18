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
                      CoffeeMachine coffeeMachine,
                      Supplier<InputStream> inputStreamSupplier) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamSupplier.get()));
        String input = "";

        cliView.askForSelection(coffeeMachine.getInventory().summary(), coffeeMachine.getDrinks().getDrinksMenu().toString());
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
                    coffeeMachine.getInventory().restock();
                } else {
                    int drinkId = parseDrinkIdAndThrowExceptionIfInvalid(input, coffeeMachine.getDrinks());
                    if (coffeeMachine.getDrinks().isMakeable(drinkId)) {
                        cliView.displayDispensingDrink(coffeeMachine.getDrinks().getName(drinkId));
                        coffeeMachine.makeDrink(drinkId);
                    } else {
                        cliView.displayOutOfStock(coffeeMachine.getDrinks().getName(drinkId));
                    }
                }
                cliView.askForSelection(coffeeMachine.getInventory().summary(), coffeeMachine.getDrinks().getDrinksMenu().toString());
            } catch (Exception e) {
                cliView.displayInvalidSelection(input);
            }
        }
    }
}
