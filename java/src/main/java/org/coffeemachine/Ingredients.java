package org.coffeemachine;

public class Ingredients {
    private final Inventory inventory;
    private final Costs costs;

    public Ingredients(Costs costs1, Inventory inventory) {
        this.inventory = inventory;
        this.costs = costs1;
    }

}
