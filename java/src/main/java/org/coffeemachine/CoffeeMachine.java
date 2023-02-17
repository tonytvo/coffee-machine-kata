package org.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CoffeeMachine {

    private static final List<Drink> drinkList = new ArrayList<>();
    private static final List<Ingredient> ingredientList = new ArrayList<>();

    public static void main(String[] args) {
        addAllIngredients();
        addAllDrinks();
        updateCosts();
        updateMakeable();
        CliView cliView = new CliView();
        cliView.askForSelection(ingredientList, drinkList);
        startIO(cliView);
    }

    public static void startIO(CliView cliView) {
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
                    restockIngredients(cliView);
                } else {
                    int drinkId = parseDrinkIdAndThrowExceptionIfInvalid(input);
                    makeDrink(drinkList.get(drinkId), cliView);
                }
                updateMakeable();
                cliView.askForSelection(ingredientList, drinkList);
            } catch (Exception e) {
                cliView.displayInvalidSelection(input);
            }
        }
    }

    private static int parseDrinkIdAndThrowExceptionIfInvalid(String input) throws IOException {
        int drinkInput = Integer.parseInt(input);
        if (drinkInput <= 0 || drinkInput > drinkList.size()) {
            throw new IOException(); // legal, but invalid input
        }
        int drinkId = drinkInput - 1;
        return drinkId;
    }

    public static void updateMakeable() {
        for (Drink d : drinkList) {
            d.updateMakable(ingredientList);
        }
    }

    public static void updateCosts() {
        for (Drink d : drinkList) {
            d.updateCost(ingredientList);
        }
    }

    public static void makeDrink(Drink drink, CliView cliView) {
        if (drink.getMakeable()) {
            cliView.displayDispensingDrink(drink.getName());
            drink.make(ingredientList);
        } else {
            cliView.displayOutOfStock(drink.getName());
        }
    }

    public static void restockIngredients(CliView cliView) {
        for (Ingredient i : ingredientList) {
            i.setStock(10);
        }
    }

    public static void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public static void addDrink(String name, String[] recipe) {
        drinkList.add(new Drink(name, recipe));
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
        addDrink("Coffee", new String[] { "Coffee", "Coffee", "Coffee", "Sugar", "Cream" });
        addDrink("Decaf Coffee", new String[] { "Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream" });
        addDrink("Caffe Latte", new String[] { "Espresso", "Espresso", "Steamed Milk" });
        addDrink("Caffe Americano", new String[] { "Espresso", "Espresso", "Espresso" });
        addDrink("Caffe Mocha", new String[] { "Espresso", "Cocoa", "Steamed Milk", "Whipped Cream" });
        addDrink("Cappuccino", new String[] { "Espresso", "Espresso", "Steamed Milk", "Foamed Milk" });

        Collections.sort(drinkList);
    }

}