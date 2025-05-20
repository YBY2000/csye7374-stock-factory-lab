package edu.neu.csye7374;

public class Stock1LazySingletonFactory {
    private static volatile Stock1LazySingletonFactory instance;

    private Stock1LazySingletonFactory() {}

    public static Stock1LazySingletonFactory getInstance() {
        if (instance == null) {
            synchronized (Stock1LazySingletonFactory.class) {
                if (instance == null) {
                    instance = new Stock1LazySingletonFactory();
                }
            }
        }
        return instance;
    }

    public Stock1 createStock(String id, double price, String description) {
        return new Stock1(id, price, description);
    }
}
