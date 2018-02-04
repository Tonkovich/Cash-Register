package net.tonkovich.java;

public class Discount20 implements DiscountOptions {

  private double percentage = 0.20;

  /**
   * This method will be called when Discount has assigned it as its behavior. This method is
   * for calculating the final price of the item/s and apply the discount.
   *
   * @param price    Price of the item
   * @param quantity How many of the item
   * @return total amount with applied discount
   */
  public double calculate(double price, int quantity) {
    double original = price * quantity;
    double subtract = original * percentage;
    return original - subtract;
  }

  public String toString() {
    return percentage * 100 + "%";
  }

}
