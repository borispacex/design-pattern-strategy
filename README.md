# Patrón de Diseño Strategy en Java

## Introducción

El **Patrón de Diseño Strategy** es un patrón de comportamiento que permite definir una familia de algoritmos, encapsularlos en clases separadas y hacer que sus objetos sean intercambiables en tiempo de ejecución.

Este patrón ayuda a evitar estructuras condicionales complejas y promueve el principio **abierto/cerrado (OCP)** de SOLID, permitiendo agregar nuevas estrategias sin modificar el código existente.

---

## Problema

Imagina que tienes una tienda en línea y necesitas aplicar diferentes tipos de descuentos a los productos. Inicialmente, puedes usar `if-else`, pero a medida que agregas más descuentos, el código se vuelve difícil de mantener y extender.

```java
public class PriceCalculator {
    public double calculatePrice(double originalPrice, String discountType) {
        if (discountType.equals("FIXED")) {
            return originalPrice - 10;
        } else if (discountType.equals("PERCENTAGE")) {
            return originalPrice * 0.80; // 20% de descuento
        } else {
            return originalPrice; // Sin descuento
        }
    }
}
```

## Solución con el Patrón Strategy

Usamos **Strategy** para separar la lógica de descuento en clases independientes.

### 1. **Interfaz Strategy**

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}
```

### 2. **Implementaciones de las Estrategias**

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
        return price * 0.80; // 20% de descuento
    }
}

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
```

### 3. **Contexto que usa las Estrategias**

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

### 4. **Uso del Patrón Strategy**

```java
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
    }
}
```

---

## Beneficios del Patrón Strategy

✅ **Cumple con el principio abierto/cerrado (OCP)**: Podemos agregar nuevos descuentos sin modificar el código del `PriceCalculator`.

✅ **Código más limpio y modular**: Cada estrategia es una clase independiente.

✅ **Facilidad de prueba y mantenimiento**: Podemos probar cada estrategia de forma independiente.

---

## Posibles Mejoras

- **Usar un Factory Pattern** para instanciar estrategias dinámicamente.
- **Implementar Strategy con Spring Boot** para inyección de dependencias.
- **Agregar nuevas estrategias** como descuentos por temporada o cupones.

---

## Conclusión

El **Patrón Strategy** nos permite escribir código flexible y mantenible al separar la lógica en clases específicas y delegar la ejecución de la estrategia adecuada según sea necesario.

Este patrón es ampliamente usado en sistemas donde se requiere flexibilidad en la elección de algoritmos, como pagos en e-commerce, ordenamientos o compresión de datos.

---

### 📌 **Referencias**

- [Documentación oficial de patrones de diseño](https://refactoring.guru/es/design-patterns/strategy)
- [Ejemplo en GitHub](https://github.com/borispacex/design-pattern-strategy)
