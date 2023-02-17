package org.coffeemachine;

import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    static StringBuffer getDrinksMenu(Drinks drinks) {
        int count = 1;
        StringBuffer menu = new StringBuffer();
        for (Drink d : drinks.getDrinkList()) {
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
