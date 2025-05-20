package edu.neu.csye7374;

public class Stock1 extends Stock {
    private double bid;

    public Stock1(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(String bid) {
        try {
            this.bid = Double.parseDouble(bid);
            price += (this.bid - price) * 0.1;
        } catch (NumberFormatException e) {
            System.err.println("Invalid bid.");
        }
    }

    @Override
    public String getMetric() {
        return String.valueOf((int)((price - 100) / 10));
    }
}
