package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private static volatile StockMarket instance;
    private Map<String, Stock> stocks = new HashMap<>();

    private StockMarket() {}

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getName(), stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void tradeStock(String name, String bid) {
        if (stocks.containsKey(name)) {
            stocks.get(name).setBid(bid);
        }
    }

    public void showAllStocks() {
        for (Stock s : stocks.values()) {
            System.out.print(s);
            System.out.println(", Metric: " + s.getMetric());
        }
    }

    public static void demo() {
        System.out.println("Running StockMarket demo...");

        // Use Singleton Factories (Factory Method + Singleton)
        Stock stock1 = Stock1LazySingletonFactory.getInstance().createStock("IBM1", 131.15, "IBM Common Stock");
        Stock stock2 = Stock2EagerSingletonFactory.getInstance().createStock("Apple", 141.15, "Apple Common Stock");

        // Add stocks to the market
        StockMarket market = StockMarket.getInstance();
        market.addStock(stock1);
        market.addStock(stock2);

        System.out.println("====== Simulating trades ======");

        String[] bids1 = {"140", "160", "180", "200", "220", "240"};
        String[] bids2 = {"130", "180", "125", "190", "120", "200"};

        System.out.println("Bids for Stock1:");
        for (String bid : bids1) {
            market.tradeStock("IBM1", bid);
            System.out.print(stock1);
            System.out.println(", Metric: " + stock1.getMetric());
        }

        System.out.println("\nBids for Stock2:");
        for (String bid : bids2) {
            market.tradeStock("Apple", bid);
            System.out.print(stock2);
            System.out.println(", Metric: " + stock2.getMetric());
        }

        // Demonstrate removing a stock
        System.out.println("\n====== Removing Stock1 (IBM1) ======");
        System.out.println("Trying to remove stock: IBM1");
        market.removeStock("IBM1");

        System.out.println("Trying to trade removed stock (IBM1):");
        market.tradeStock("IBM1", "300"); // Should have no effect

        System.out.println("\nCurrent stocks in market:");
        market.showAllStocks(); // Should only show Apple
    }
}
