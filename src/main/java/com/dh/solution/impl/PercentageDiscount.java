package com.dh.solution.impl;

import com.dh.solution.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.80; // 20% de descuento
    }
}
