package org.coffeemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks() {
        this.drinkList = new ArrayList<>();
    }

    boolean isValidDrinkInput(int drinkInput) {
        return drinkInput > getDrinkList().size();
    }

    void sort() {
        Collections.sort(getDrinkList());
    }

    public void addDrink(String name, String[] recipe) {
        getDrinkList().add(new Drink(name, recipe));
    }

    public void updateCosts(List<Ingredient> ingredientList) {
        for (Drink d : getDrinkList()) {
            d.updateCost(ingredientList);
        }
    }

    StringBuffer getDrinksMenu() {
        int count = 1;
        StringBuffer menu = new StringBuffer();
        for (Drink d : getDrinkList()) {
            menu.append(String.format("%d,%s,$%.2f," + d.getMakeable() + "\n", count, d.getName(), d.getCost()));
            count++;
        }
        return menu;
    }

    Drink getDrink(int drinkId) {
        return getDrinkList().get(drinkId);
    }

    public void updateMakeable(Ingredients ingredients) {
        for (Drink d : getDrinkList()) {
            d.updateMakable(ingredients.getIngredientList());
        }
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
}
