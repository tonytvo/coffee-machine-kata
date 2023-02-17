package org.coffeemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    static final List<Drink> drinkList = new ArrayList<>();
    static final List<Ingredient> ingredientList = new ArrayList<>();

    static void initModel() {
        addAllIngredients();
        addAllDrinks();
        new Drinks(drinkList).updateCosts(ingredientList);
        new Drinks(drinkList).updateMakeable(ingredientList);
    }

    public static void makeDrink(Drink drink, CliView cliView) {
        if (drink.getMakeable()) {
            cliView.displayDispensingDrink(drink.getName());
            drink.make(ingredientList);
        } else {
            cliView.displayOutOfStock(drink.getName());
        }
    }

    public static void restockIngredients() {
        for (Ingredient i : ingredientList) {
            i.setStock(10);
        }
    }

    public static void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public static void addAllIngredients() {
        addIngredient(new Ingredient("Coffee", 0.75));
        addIngredient(new Ingredient("Decaf Coffee", 0.75));
        addIngredient(new Ingredient("Sugar", 0.25));
        addIngredient(new Ingredient("Cream", 0.25));
        addIngredient(new Ingredient("Steamed Milk", 0.35));
        addIngredient(new Ingredient("Foamed Milk", 0.35));
        addIngredient(new Ingredient("Espresso", 1.10));
        addIngredient(new Ingredient("Cocoa", 0.90));
        addIngredient(new Ingredient("Whipped Cream", 1.00));

        Collections.sort(ingredientList);
    }

    public static void addAllDrinks() {
        new Drinks(drinkList).addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        new Drinks(drinkList).addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        new Drinks(drinkList).addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        new Drinks(drinkList).addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        new Drinks(drinkList).addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        new Drinks(drinkList).addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        sort(drinkList);
    }

    private static void sort(List<Drink> drinkList) {
        Collections.sort(drinkList);
    }
}
