# Strategy Design Pattern in Java

## Introduction

The **Strategy Design Pattern** is a behavioral pattern that allows defining a family of algorithms, encapsulating them in separate classes, and making their objects interchangeable at runtime.

This pattern helps avoid complex conditional structures and promotes the **Open/Closed Principle (OCP)** of SOLID, allowing new strategies to be added without modifying existing code.

---

## Problem

Imagine you have an online store and need to apply different types of discounts to products. Initially, you might use `if-else`, but as you add more discounts, the code becomes difficult to maintain and extend.

```java
public class PriceCalculator {
    public double calculatePrice(double originalPrice, String discountType) {
        if (discountType.equals("FIXED")) {
            return originalPrice - 10;
        } else if (discountType.equals("PERCENTAGE")) {
            return originalPrice * 0.80; // 20% discount
        } else {
            return originalPrice; // No discount
        }
    }
}
```

## Solution with the Strategy Pattern

We use **Strategy** to separate the discount logic into independent classes.

### Structure
![Design Pattern Strategy Structure](/src/main/resources/img/design-pattern-strategy-structure.png)

#### Solution
![Design Pattern Strategy](/src/main/resources/img/design-pattern-strategy.png)

### 1. **Strategy Interface**

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}
```

### 2. **Strategy Implementations**

```java
public class FixedDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price - 10;
    }
}

public class PercentageDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.80; // 20% discount
    }
}

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
```

### 3. **Context Using the Strategies**

```java
public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double originalPrice) {
        return discountStrategy.applyDiscount(originalPrice);
    }
}
```

### 4. **Using the Strategy Pattern**

```java
public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        // Use fixed discount
        calculator.setDiscountStrategy(new FixedDiscount());
        System.out.println("Price with fixed discount: $" + calculator.calculatePrice(100));

        // Switch to percentage discount
        calculator.setDiscountStrategy(new PercentageDiscount());
        System.out.println("Price with 20% discount: $" + calculator.calculatePrice(100));

        // No discount
        calculator.setDiscountStrategy(new NoDiscount());
        System.out.println("Price without discount: $" + calculator.calculatePrice(100));
    }
}
```

---

## Benefits of the Strategy Pattern

✅ **Follows the Open/Closed Principle (OCP)**: We can add new discounts without modifying the `PriceCalculator` code.

✅ **Cleaner and more modular code**: Each strategy is an independent class.

✅ **Easier testing and maintenance**: We can test each strategy independently.

---

## Possible Improvements

- **Use a Factory Pattern** to instantiate strategies dynamically.
- **Implement Strategy with Spring Boot** for dependency injection.
- **Add new strategies** such as seasonal discounts or coupons.

---

## Conclusion

The **Strategy Pattern** allows us to write flexible and maintainable code by separating logic into specific classes and delegating the execution of the appropriate strategy as needed.

This pattern is widely used in systems where flexibility in algorithm selection is required, such as e-commerce payments, sorting algorithms, or data compression.

---

### 📌 **References**

- [Official Design Patterns Documentation](https://refactoring.guru/design-patterns/strategy)
- [Example on GitHub](https://github.com/borispacex/design-pattern-strategy)
