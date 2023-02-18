package org.coffeemachine;

import java.util.*;

public class Ingredients {
    private final List<Ingredient> ingredientList;
    private final Inventory inventory;

    public Ingredients() {
        this.ingredientList = new ArrayList<>();
        this.inventory = new Inventory();
    }

    void updateIngredientsStockPerRecipe(Recipe recipe) {
        inventory.reduceFrom(recipe);
        for (Ingredient i : getIngredientList()) {
            if (recipe.contains(i)) {
                i.setStock(i.getStock() - recipe.getQuantity(i));
            }
        }
    }

    void sort() {
        Collections.sort(getIngredientList());
    }

    boolean isMakeable(Recipe recipe) {
        return getIngredientList().stream().allMatch(recipe::isMakeable);
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredientList().add(ingredient);
        inventory.restock(ingredient);
    }

    StringBuffer getInventory() {
        StringBuffer inventory = new StringBuffer();
        for (Ingredient i : getIngredientList()) {
            String inventoryForIngreident = i.getName() + "," + i.getStock();
            inventory.append(inventoryForIngreident).append("\n");
        }
        return inventory;
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
                currCost += i.getCost() * recipe.getQuantity(i);
            }
        }
        return currCost;
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
                    .forEach(ingredient -> inventoryByIngredient.put(ingredient, inventoryByIngredient.get(ingredient) - recipe.getQuantity(ingredient)));

        }
    }
}
