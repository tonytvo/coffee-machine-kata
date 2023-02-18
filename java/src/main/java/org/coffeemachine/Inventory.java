package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Inventory {

    private final Map<Ingredient, Integer> inventoryByIngredient;

    public Inventory() {
        inventoryByIngredient = new HashMap<>();
    }

    public void restock(Ingredient ingredient) {
        inventoryByIngredient.put(ingredient, 10);
    }

    public void restock() {
        inventoryByIngredient.keySet().forEach(this::restock);
    }

    public void reduceFrom(Recipe recipe) {
        inventoryByIngredient.keySet().stream()
                .filter(recipe::contains)
                .forEach(ingredient -> inventoryByIngredient.put(ingredient, inventoryByIngredient.get(ingredient) - recipe.quantityFor(ingredient)));

    }

    public boolean canMake(Recipe recipe) {
        return inventoryByIngredient.keySet().stream()
                .allMatch(ingredient -> inventoryByIngredient.get(ingredient) >= recipe.quantityFor(ingredient));
    }

    public String summary() {
        return inventoryByIngredient.keySet().stream()
                .sorted()
                .map(ingredient -> ingredient.getName() + "," + inventoryByIngredient.get(ingredient))
                .collect(Collectors.joining("\n")) + "\n";
    }
}
