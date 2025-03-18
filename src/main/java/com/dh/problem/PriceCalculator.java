package com.dh.problem;

public class PriceCalculator {
    public double calculatePrice(double originalPrice, String discountType) {
        if (discountType.equals("FIXED")) {
            System.out.println("Precio con descuento fijo: $" + (originalPrice - 10));
            return originalPrice - 10;
        } else if (discountType.equals("PERCENTAGE")) {
            System.out.println("Precio con 20% de descuento: $" + (originalPrice * 0.80));
            return originalPrice * 0.80; // 20% de descuento
        } else {
            System.out.println("Precio sin descuento: $" + (originalPrice));
            return originalPrice; // Sin descuento
        }
    }
}
