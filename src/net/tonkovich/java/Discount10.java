package net.tonkovich.java;

public class Discount10 implements DiscountOptions {

  private double percentage = 0.10;
  
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
