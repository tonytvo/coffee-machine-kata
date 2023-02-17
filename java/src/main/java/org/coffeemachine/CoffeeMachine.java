package org.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    public static void main(String[] args) {
        Model.initModel();
        CliView cliView = new CliView();
        cliView.askForSelection(Model.ingredientList, new Drinks(Model.drinkList));
        startIO(cliView, new Drinks(Model.drinkList));
    }

    public static void startIO(CliView cliView, Drinks drinks) {
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
                    Model.restockIngredients();
                } else {
                    int drinkId = parseDrinkIdAndThrowExceptionIfInvalid(input);
                    Model.makeDrink(drinks.getDrink(drinkId), cliView);
                }
                drinks.updateMakeable(Model.ingredientList);
                cliView.askForSelection(Model.ingredientList, drinks);
            } catch (Exception e) {
                cliView.displayInvalidSelection(input);
            }
        }
    }

    private static int parseDrinkIdAndThrowExceptionIfInvalid(String input) throws IOException {
        int drinkInput = Integer.parseInt(input);
        if (drinkInput <= 0 || new Drinks(Model.drinkList).isValidDrinkInput(drinkInput)) {
            throw new IOException(); // legal, but invalid input
        }
        return drinkInput - 1;
    }

}