package edu.neu.csye7374;

public class Stock1Factory {
    public Stock1 createStock(String id, double price, String description) {
        return new Stock1(id, price, description);
    }
}
