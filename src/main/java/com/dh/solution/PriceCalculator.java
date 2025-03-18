package com.dh.solution;

public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double originalPrice) {
        return discountStrategy.applyDiscount(originalPrice);
    }
}
