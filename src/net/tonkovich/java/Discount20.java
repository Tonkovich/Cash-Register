package net.tonkovich.java;

public class Discount20 implements PercentageDiscount {
  
  private double percentage = 0.20;

  public double calculate(double price, double quantity) {
    double original = price*quantity;
    double subtract = original * percentage;
    return original - subtract;
  }

  public double getPercentage() {
    return percentage;
  }
  
  public String toString() {
    String result = percentage*100 + "%";
    return result;
  }

}