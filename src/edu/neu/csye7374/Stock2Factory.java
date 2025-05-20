package edu.neu.csye7374;

public class Stock2Factory {
    public Stock2 createStock(String id, double price, String description) {
        return new Stock2(id, price, description);
    }
}
