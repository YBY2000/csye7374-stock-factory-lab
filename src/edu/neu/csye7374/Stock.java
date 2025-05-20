package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    protected String name;
    protected double price;
    protected String description;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Stock ID: %s, Price: $%.2f, Description: %s", name, price, description);
    }


    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
