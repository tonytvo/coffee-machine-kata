package org.coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class Model {
    static final Drinks drinks = new Drinks();
    static final List<Ingredient> ingredientList = new ArrayList<>();

    static void initModel(Drinks drinks) {
        addAllIngredients(new Ingredients(ingredientList));
        addAllDrinks(drinks);
        drinks.updateCosts(new Ingredients(ingredientList));
        drinks.updateMakeable(new Ingredients(ingredientList));
    }

    public static void makeDrink(Drink drink, CliView cliView, Ingredients ingredients) {
        if (drink.getMakeable()) {
            cliView.displayDispensingDrink(drink.getName());
            drink.make(ingredients);
        } else {
            cliView.displayOutOfStock(drink.getName());
        }
    }

    public static void addAllIngredients(Ingredients ingredients) {
        ingredients.addIngredient(new Ingredient("Coffee", 0.75));
        ingredients.addIngredient(new Ingredient("Decaf Coffee", 0.75));
        ingredients.addIngredient(new Ingredient("Sugar", 0.25));
        ingredients.addIngredient(new Ingredient("Cream", 0.25));
        ingredients.addIngredient(new Ingredient("Steamed Milk", 0.35));
        ingredients.addIngredient(new Ingredient("Foamed Milk", 0.35));
        ingredients.addIngredient(new Ingredient("Espresso", 1.10));
        ingredients.addIngredient(new Ingredient("Cocoa", 0.90));
        ingredients.addIngredient(new Ingredient("Whipped Cream", 1.00));

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
