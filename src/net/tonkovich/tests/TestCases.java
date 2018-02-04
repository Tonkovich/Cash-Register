package net.tonkovich.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.tonkovich.java.Discount;
import net.tonkovich.java.Discount10;
import net.tonkovich.java.Discount20;
import net.tonkovich.java.DiscountOptions;

import org.junit.jupiter.api.Test;

class TestCases {

  private List<DiscountOptions> dList = new ArrayList<DiscountOptions>() {
    {
      add(new Discount10());
      add(new Discount20());
    }
  };

  private Discount dis = Discount.getInstance();

  @Test
  void discount10Test() {
    dis.setDiscount(new Scanner("1"), dList); // Assign option
    DecimalFormat df = new DecimalFormat("#.##");

    dis.setUnitPrice(new Scanner("2.52"));
    dis.setQuantity(new Scanner("7"));

    double value = dis.calculate();

    assertEquals("15.88", df.format(value), "Value should be 15.88");
  }

  @Test
  void discount20Test() {
    dis.setDiscount(new Scanner("2"), dList); // Assign option
    DecimalFormat df = new DecimalFormat("#.##");

    dis.setUnitPrice(new Scanner("2.52")); // Assign test values
    dis.setQuantity(new Scanner("7"));

    double value = dis.calculate();

    assertEquals("14.11", df.format(value), "Value should be 14.11");
  }

  @Test
  void totalTest() {
    dis.setUnitPrice(new Scanner("2.52")); // Assign test values
    dis.setQuantity(new Scanner("7"));
    dis.setDiscount(new Scanner("2"), dList);

    double total = dis.calculate();

    dis.setUnitPrice(new Scanner("3")); // Assign test values
    dis.setQuantity(new Scanner("2"));
    dis.setDiscount(new Scanner("1"), dList);

    total += dis.calculate();

    DecimalFormat df = new DecimalFormat("#.##");
    assertEquals("19.51", df.format(total), "Value should be 19.51");
  }

  @Test
  void wrongUserInputTest() {
    dis.setUnitPrice(new Scanner("a"));
    dis.setUnitPrice(new Scanner("b"));
    dis.setUnitPrice(new Scanner("c")); // Incorrect inputs
    dis.setUnitPrice(new Scanner("d"));

    dis.setUnitPrice(new Scanner("2.52")); // Correct input

    dis.setQuantity(new Scanner("a"));
    dis.setQuantity(new Scanner("b")); // Incorrect input
    dis.setQuantity(new Scanner("c"));
    dis.setQuantity(new Scanner("d"));

    dis.setQuantity(new Scanner("7")); // Correct input

    dis.setDiscount(new Scanner("10000"), dList);
    dis.setDiscount(new Scanner("-10000"), dList); // Incorrect inputs
    dis.setDiscount(new Scanner("z"), dList);

    dis.setDiscount(new Scanner("2"), dList); // Correct input

    // Now lets check whether if the discount can still be calculated
    double answer = dis.calculate();

    DecimalFormat df = new DecimalFormat("#.##");
    assertEquals("14.11", df.format(answer), "Value should be 14.11");
  }
}
