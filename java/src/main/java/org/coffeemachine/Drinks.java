package org.coffeemachine;

import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
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
