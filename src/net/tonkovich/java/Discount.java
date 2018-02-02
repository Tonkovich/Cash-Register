package net.tonkovich.java;

public class Discount {
  
  DiscountOptions d;
  
  public double calculate(double price, int quantity) {
    return d.calculate(price, quantity);
  }
  
  public String toString() {
    return d.toString();
  }
  
  public void setDiscount(DiscountOptions newD) {
    d = newD;
  }
}
