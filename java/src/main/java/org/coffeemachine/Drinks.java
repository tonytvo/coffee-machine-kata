package org.coffeemachine;

import java.util.Collections;
import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    static void sort(Drinks drinks) {
        Collections.sort(drinks.getDrinkList());
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

    public void updateMakeable(List<Ingredient> ingredientList) {
        for (Drink d : getDrinkList()) {
            d.updateMakable(ingredientList);
        }
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
}
