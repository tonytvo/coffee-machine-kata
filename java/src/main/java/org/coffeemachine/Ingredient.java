package org.coffeemachine;

public class Ingredient implements Comparable<Ingredient> {
    private final String name;
    private final double cost;
    private int stock;

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.stock = 10;
    }

    public int compareTo(Ingredient ingredient) {
        return name.compareTo(ingredient.getName());
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

}