package net.tonkovich.java;

public interface DiscountOptions {
  
  double calculate(double price, double quantity);
  
  double getPercentage();
}
