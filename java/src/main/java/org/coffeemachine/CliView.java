package org.coffeemachine;

import java.io.PrintStream;
import java.util.function.Supplier;

public class CliView {

    private final Supplier<PrintStream> outputStreamSupplier;

    public CliView(Supplier<PrintStream> printStreamSupplier) {
        outputStreamSupplier = printStreamSupplier;
    }

    public void askForSelection(String inventory, String drinksMenu) {
        outputStreamSupplier.get().println("Inventory:");
        outputStreamSupplier.get().print(inventory);

        outputStreamSupplier.get().println("\nMenu:");
        outputStreamSupplier.get().print(drinksMenu);

        outputStreamSupplier.get().print("\nYour selection: ");
    }

    void displayOutOfStock(String drinkName) {
        outputStreamSupplier.get().println("Out of stock: " + drinkName + "\n");
    }

    void displayDispensingDrink(String drinkName) {
        outputStreamSupplier.get().println("Dispensing: " + drinkName + "\n");
    }

    void displayInvalidSelection(String input) {
        outputStreamSupplier.get().print("Invalid selection: " + input + ". Try again: "); // illegal input
    }
}