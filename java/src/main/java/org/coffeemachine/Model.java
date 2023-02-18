package org.coffeemachine;

public class Model {
    static final Drinks drinks = new Drinks();
    static final Ingredients ingredients = new Ingredients();

    static void initModel(Drinks drinks, Ingredients ingredients) {
        addAllIngredients(ingredients);
        addAllDrinks(drinks);
        drinks.updateCosts(ingredients);
        drinks.updateMakeable(ingredients);
    }

    public static void addAllIngredients(Ingredients ingredients) {
        ingredients.addIngredient(new Ingredient("Coffee", 0.75), 0.75);
        ingredients.addIngredient(new Ingredient("Decaf Coffee", 0.75), 0.75);
        ingredients.addIngredient(new Ingredient("Sugar", 0.25), 0.25);
        ingredients.addIngredient(new Ingredient("Cream", 0.25), 0.25);
        ingredients.addIngredient(new Ingredient("Steamed Milk", 0.35), 0.35);
        ingredients.addIngredient(new Ingredient("Foamed Milk", 0.35), 0.35);
        ingredients.addIngredient(new Ingredient("Espresso", 1.10), 1.10);
        ingredients.addIngredient(new Ingredient("Cocoa", 0.90), 0.90);
        ingredients.addIngredient(new Ingredient("Whipped Cream", 1.00), 1.00);

        ingredients.sort();
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
