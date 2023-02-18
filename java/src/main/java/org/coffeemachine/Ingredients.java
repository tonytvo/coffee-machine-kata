package org.coffeemachine;

import java.util.*;
import java.util.stream.Collectors;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;

    public Ingredients() {
        this.ingredientList = new ArrayList<>();
        this.inventory = new Inventory();
    }

    void updateIngredientsStockPerRecipe(Recipe recipe) {
        inventory.reduceFrom(recipe);
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return inventory.canMake(recipe);
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredientList().add(ingredient);
        inventory.restock(ingredient);
    }

    String getInventory() {
        return inventory.summary();
    }

    public void restockIngredients() {
        inventory.restock();
        for (Ingredient i : getIngredientList()) {
            i.setStock(10);
        }
    }

    private List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    double calculateCost(Recipe recipe) {
        double currCost = 0;
        for (Ingredient i : getIngredientList()) {
            if (recipe.contains(i)) {
                currCost += i.getCost() * recipe.quantityFor(i);
            }
        }
        return currCost;
    }

    public void clear() {
        ingredientList.clear();
    }

    private static class Inventory {

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

        private String summary() {
            return inventoryByIngredient.keySet().stream()
                    .sorted()
                    .map(ingredient -> ingredient.getName() + "," + inventoryByIngredient.get(ingredient))
                    .collect(Collectors.joining("\n")) + "\n";
        }
    }
}
