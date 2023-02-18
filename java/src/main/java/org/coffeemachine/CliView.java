package org.coffeemachine;

public class CliView {

    public void askForSelection(Drinks drinks, Ingredients ingredients) {
        System.out.println("Inventory:");
        StringBuffer inventory = ingredients.getInventory();
        System.out.print(inventory);

        System.out.println("\nMenu:");
        System.out.print(drinks.getDrinksMenu());

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