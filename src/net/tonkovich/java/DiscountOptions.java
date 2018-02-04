package net.tonkovich.java;

/**
 * Interface for all discount options.
 */
public interface DiscountOptions {

  double calculate(double price, int quantity);

  String toString();
}
