package net.tonkovich.java;

public interface DiscountOptions {

  double calculate(double price, int quantity);

  String toString();
}
