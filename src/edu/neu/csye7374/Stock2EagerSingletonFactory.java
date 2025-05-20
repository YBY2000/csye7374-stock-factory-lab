package edu.neu.csye7374;

public class Stock2EagerSingletonFactory {
    private static final Stock2EagerSingletonFactory instance = new Stock2EagerSingletonFactory();

    private Stock2EagerSingletonFactory() {
        // private constructor
    }

    public static Stock2EagerSingletonFactory getInstance() {
        return instance;
    }

    public Stock2 createStock(String id, double price, String description) {
        return new Stock2(id, price, description);
    }
}