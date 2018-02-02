package net.tonkovich.java;

public interface PercentageDiscount {
  
  double calculate(double price, double quantity);
  
  double getPercentage();
}
