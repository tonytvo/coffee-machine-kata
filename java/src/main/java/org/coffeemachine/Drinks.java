package org.coffeemachine;

import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public static void updateMakeable(List<Ingredient> ingredientList, Drinks drinks) {
        for (Drink d : drinks.getDrinkList()) {
            d.updateMakable(ingredientList);
        }
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
}
