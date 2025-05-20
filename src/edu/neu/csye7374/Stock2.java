package edu.neu.csye7374;

public class Stock2 extends Stock {
    private double bid;

    public Stock2(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(String bid) {
        try {
            this.bid = Double.parseDouble(bid);
            price += (this.bid - price) * 0.2;
        } catch (NumberFormatException e) {
            System.err.println("Invalid bid.");
        }
    }

    @Override
    public String getMetric() {
        if (price < 150) return "-2";
        else if (price <= 180) return "1";
        else return "3";
    }

}
