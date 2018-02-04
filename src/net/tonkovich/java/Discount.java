package net.tonkovich.java;

import java.util.List;
import java.util.Scanner;

/**
 * Singleton that parses and holds data pertaining to user input.
 */
public class Discount {

  private static Discount instance = new Discount();
  private DiscountOptions d;
  private double unitPrice = 0.0;
  private int quantity = 0;

  private Discount() {
    // Change constructor to private
  }

  public static Discount getInstance() {
    return instance;
  }

  /**
   * After the behavior, unitPrice, and quantity have been assigned this method will use the
   * assigned behaviors method to calculate the final price.
   *
   * @return Final price after discount
   */
  public double calculate() {
    return d.calculate(unitPrice, quantity);
  }

  /**
   * This method takes in user input, parses it, and assigns the behavior the user wants.
   * If the user enters incorrect input the method will recurse and ask the user again
   * indefinitely until correct input is entered.
   *
   * @param scan      Scanner object to get user input
   * @param discounts List of discount options
   */
  public void setDiscount(Scanner scan, List<DiscountOptions> discounts) {
    int selection;
    try {
      // Input comes from console expects a stream and waits for input if none or continue if is
      if (scan.hasNext()) {
        selection = Integer.parseInt(scan.next().trim());
        if (selection <= discounts.size() && selection >= 1) {
          d = discounts.get(selection - 1);
        } else {
          // Throw exception if selection outOfBounds
          throw new Exception("Please choose an option presented.");
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Incorrect selection: Try again");
      setDiscount(scan, discounts); // Recursive call
    }
  }

  /**
   * This method takes in user input, parses it, and assigns the unit price for the item the
   * user is trying to calculate. If the user inputs a price incorrectly the method will
   * recurse indefinitely until correct input is entered.
   *
   * @param scan Scanner object to get user input
   */
  public void setUnitPrice(Scanner scan) {
    try {
      if (scan.hasNext()) // Used to avoid stack overflow, will still wait for user input
        unitPrice = Double.parseDouble(scan.next().trim());
    } catch (Exception e) {
      System.out.println("Incorrect price format: Try again");
      setUnitPrice(scan); // Recursive call
    }
  }

  /**
   * This method takes in user input, parses it, and assigns the quantity of the items the
   * user is trying to calculate. If the user inputs a quantity incorrectly the method will
   * recurse indefinitely until correct input is entered.
   *
   * @param scan Scanner object to get user input
   */
  public void setQuantity(Scanner scan) {
    try {
      if (scan.hasNext()) // Used to avoid stack overflow, will still wait for user input
        quantity = Integer.parseInt(scan.next().trim());
    } catch (Exception e) {
      System.out.println("Incorrect quantity format: Try again");
      setQuantity(scan);  // Recursive call
    }
  }

  public String toString() {
    return d.toString();
  }
}
