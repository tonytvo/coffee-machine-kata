package org.coffeemachine;

import java.io.PrintStream;

public class CliView {

    public void askForSelection(Drinks drinks, Ingredients ingredients) {
        getOutputStream().println("Inventory:");
        StringBuffer inventory = ingredients.getInventory();
        getOutputStream().print(inventory);

        getOutputStream().println("\nMenu:");
        getOutputStream().print(drinks.getDrinksMenu());

        getOutputStream().print("\nYour selection: ");
    }

    private static PrintStream getOutputStream() {
        return System.out;
    }

    void displayOutOfStock(String drinkName) {
        getOutputStream().println("Out of stock: " + drinkName + "\n");
    }

    void displayDispensingDrink(String drinkName) {
        getOutputStream().println("Dispensing: " + drinkName + "\n");
    }

    void displayInvalidSelection(String input) {
        getOutputStream().print("Invalid selection: " + input + ". Try again: "); // illegal input
    }
}