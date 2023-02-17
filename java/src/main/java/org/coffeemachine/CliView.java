package org.coffeemachine;

import java.util.List;

public class CliView {

    public void askForSelection(List<Ingredient> ingredientList, List<Drink> drinkList) {
        System.out.println("Inventory:");
        for (Ingredient i : ingredientList) {
            System.out.println(i.getName() + "," + i.getStock());
        }

        System.out.println("\nMenu:");
        int count = 1;
        for (Drink d : drinkList) {
            System.out.printf("%d,%s,$%.2f," + d.getMakeable() + "\n", count, d.getName(), d.getCost());
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    void displayOutOfStock(String drinkName) {
        System.out.println("Out of stock: " + drinkName + "\n");
    }

    void displayDispensingDrink(String drinkName) {
        System.out.println("Dispensing: " + drinkName + "\n");
    }

    void displayInvalidSelection(String input) {
        System.out.print("Invalid selection: " + input + ". Try again: "); // illegal input
    }
}