package org.example.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private List<Double> prices = new ArrayList<>();
    double discount = 0;

    public double getTotal() {
        double total = 0;
        for (Double price : prices) {
            if (discount > 0) {
                price = price - (price * discount / 100);
            }
            total += price;
        }
        return total;
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
