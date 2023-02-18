package org.coffeemachine;

public class Model {
    static void initModel(Drinks drinks, Costs costs, Inventory inventory) {
        addAllIngredients(costs, inventory);
        addAllDrinks(drinks);
    }

    public static void addAllIngredients(Costs costs, Inventory inventory) {
        addIngredient("Coffee", inventory, costs, 0.75);

        addIngredient("Decaf Coffee", inventory, costs, 0.75);

        addIngredient("Sugar", inventory, costs, 0.25);

        addIngredient("Cream", inventory, costs, 0.25);

        addIngredient("Steamed Milk", inventory, costs, 0.35);

        addIngredient("Foamed Milk", inventory, costs, 0.35);

        addIngredient("Espresso", inventory, costs, 1.10);

        addIngredient("Cocoa", inventory, costs, 0.90);

        addIngredient("Whipped Cream", inventory, costs, 1.00);
    }

    private static void addIngredient(String Coffee, Inventory inventory, Costs costs, double cost) {
        Ingredient ingredient8 = new Ingredient(Coffee);
        inventory.restock(ingredient8);
        costs.set(ingredient8, cost);
    }

    public static void addAllDrinks(Drinks drinks) {
        drinks.addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        drinks.addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        drinks.addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        drinks.addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        drinks.addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        drinks.addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        drinks.sort();
    }

}
