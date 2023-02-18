package org.coffeemachine;

import java.util.List;

public class CliView {

    public void askForSelection(List<Ingredient> ingredientList, Drinks drinks) {
        System.out.println("Inventory:");
        StringBuffer inventory = getInventory(new Ingredients(ingredientList));
        System.out.print(inventory);

        System.out.println("\nMenu:");
        System.out.print(drinks.getDrinksMenu());

        System.out.print("\nYour selection: ");
    }

    private static StringBuffer getInventory(Ingredients ingredients) {
        StringBuffer inventory = new StringBuffer();
        for (Ingredient i : ingredients.getIngredientList()) {
            String inventoryForIngreident = i.getName() + "," + i.getStock();
            inventory.append(inventoryForIngreident).append("\n");
        }
        return inventory;
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