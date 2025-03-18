package com.dh.solution.impl;

import com.dh.solution.DiscountStrategy;

public class FixedDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price - 10;
    }
}
