package net.tonkovich.java;

public interface Discount {
  double calculate(double price, double quantity);
  
  String toString();
}
