package net.tonkovich.java;

public class Discount {
  
  DiscountOptions pd;
  
  double calculate(double price, double quantity) {
    return pd.calculate(price, quantity);
  }
  
  public String toString() {
    return pd.toString();
  }
  
  public void setPd(DiscountOptions newPD) {
    pd = newPD;
  }
}
