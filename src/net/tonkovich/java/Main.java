package net.tonkovich.java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); 
    Discount disc = new Discount();
    
    List<DiscountOptions> discounts = new ArrayList<DiscountOptions>() {{
      add(new Discount10());
      add(new Discount20());
    }};
    
    boolean cont = true;
    double total = 0.0;
    
    while(cont) {
      System.out.println("Unit Price ($)");
      double unitPrice = getUnitPrice(scan); // get UnitPrice
      
      System.out.println("Quantity");
      int quantity = getQuantity(scan); // get Quantity of item
      
      System.out.println("Discounts: ");
      
      int i = 1;
      for (DiscountOptions d : discounts) {
        System.out.println(i + ". " + d.toString()); // Print out discount options
        i++;
      }
      int selection = scan.nextInt() -1 ;
      
      disc.setDiscount(discounts.get(selection)); // Assign behavior
      
      total += disc.calculate(unitPrice, quantity);
      
      System.out.println("Total: ");
      System.out.printf("%.2f \n", disc.calculate(unitPrice, quantity)); // Print out adjusted price
      System.out.println("Another item? (Y/N)");
      
      String answer = scan.next();
      
      if (!answer.equalsIgnoreCase("y"))
        cont = false;
    }
    scan.close();
  }
  
  public static double getUnitPrice(Scanner scan) {
  	double result = 0.0; // Default
  	try {
  		result = scan.nextDouble();
  	} 
  	catch (InputMismatchException e) {
  		System.out.println("Incorrect number format: Try again");
  		String result2 = scan.nextLine();
  		getUnitPrice(new Scanner(result2));
  	}
  	return result;
  }
  
  public static int getQuantity(Scanner scan) {
  	int result = 0;
  	try {
  		result = scan.nextInt();
  	} 
  	catch (InputMismatchException e) {
  		System.out.println("Incorrect number format: Try again");
  		getQuantity(new Scanner(scan.next()));
  	}
  	return result;
  }
  
}
