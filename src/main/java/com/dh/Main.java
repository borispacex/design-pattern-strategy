package com.dh;

/*
import com.dh.problem.PriceCalculator;
*/

import com.dh.solution.PriceCalculator;
import com.dh.solution.impl.FixedDiscount;
import com.dh.solution.impl.NoDiscount;
import com.dh.solution.impl.PercentageDiscount;

public class Main {
    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        // Usar descuento fijo
        calculator.setDiscountStrategy(new FixedDiscount());
        System.out.println("Precio con descuento fijo: $" + calculator.calculatePrice(100));

        // Cambiar a descuento porcentual
        calculator.setDiscountStrategy(new PercentageDiscount());
        System.out.println("Precio con 20% de descuento: $" + calculator.calculatePrice(100));

        // Sin descuento
        calculator.setDiscountStrategy(new NoDiscount());
        System.out.println("Precio sin descuento: $" + calculator.calculatePrice(100));

        /*
        PriceCalculator calculator = new PriceCalculator();
        calculator.calculatePrice(100, "FIXED");
        calculator.calculatePrice(100, "PERCENTAGE");
        calculator.calculatePrice(100, "NO");
        */
    }
}