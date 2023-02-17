package org.coffeemachine;

import java.util.List;

public class Drinks {
    private final List<Drink> drinkList;

    public Drinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void updateMakeable(List<Ingredient> ingredientList) {
        for (Drink d : getDrinkList()) {
            d.updateMakable(ingredientList);
        }
    }

    private List<Drink> getDrinkList() {
        return drinkList;
    }
}
