package net.tonkovich.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); 
    
    List<PercentageDiscount> pDiscounts = new ArrayList<PercentageDiscount>() {{
      add(new Discount10());
      add(new Discount20());
    }};
    
    boolean cont = true;
    
    while(cont) {
      System.out.println("Unit Price ($)");
      double unitPrice = scan.nextDouble();
      
      System.out.println("Quantity");
      int quantity = scan.nextInt();
      
      System.out.println("Discounts: ");
      
      int i = 1;
      for(PercentageDiscount pD : pDiscounts) {
        System.out.println(i + ". " + pD.toString());
        i++;
      }
      int selection = scan.nextInt() -1 ;
      
      System.out.print("Total: ");
      System.out.printf("%.2f \n", pDiscounts.get(selection).calculate(unitPrice, quantity));
      System.out.println("Another Discount? (Y/N)");
      
      String answer = scan.next();
      
      if(!answer.equalsIgnoreCase("y"))
        cont = false;
    }
    scan.close();
  }
}
