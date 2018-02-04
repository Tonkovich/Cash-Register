package net.tonkovich.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static Discount disc = Discount.getInstance();


  /**
   * Main class holds the procedure code for the cash register.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Initialize discount options
    List<DiscountOptions> discounts = new ArrayList<DiscountOptions>() {
      {
        add(new Discount10());
        add(new Discount20());
      }
    };

    boolean cont = true;
    double total = 0.0;

    while (cont) {
      System.out.println("Unit Price ($)");
      disc.setUnitPrice(scan); // set Unit Price

      System.out.println("Quantity: ");
      disc.setQuantity(scan); // set Quantity of item

      System.out.println("Discounts: ");

      int i = 1;
      for (DiscountOptions d : discounts) {
        System.out.println(i + ". " + d.toString()); // Print out discount options
        i++;
      }

      disc.setDiscount(scan, discounts); // Assign behavior

      total += disc.calculate(); // Accumulate total

      System.out.println("Total: ");
      System.out.printf("%.2f \n", total); // Print out adjusted price

      System.out.println("Another item? (Y/N)");
      if (!scan.next().equalsIgnoreCase("y")) {
        cont = false;
      }
    }
    scan.close(); // Close scanner
  }
}
