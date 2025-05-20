package edu.neu.csye7374;

public interface Tradeable1 extends Tradable {
    default String getMetric() {
        return "Tradeable1: Default Metric";
    }
}
