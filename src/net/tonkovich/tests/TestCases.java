package net.tonkovich.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import net.tonkovich.java.Discount;
import net.tonkovich.java.Discount10;
import net.tonkovich.java.Discount20;

class TestCases {
	
	//TODO: Simulate virtual user

	@Test
	void discount10Test() {
		Discount dis = new Discount();
		dis.setDiscount(new Discount10()); // Assign option
		DecimalFormat df = new DecimalFormat("#.##"); 
		
		double price = 2.52; // Assign test values
		int quantity = 7;
		
		double value = dis.calculate(price, quantity);
		
		assertEquals("15.88", df.format(value), "Value should be 15.88");
	}
	
	@Test
	void discount20Test() {
		Discount dis = new Discount();
		dis.setDiscount(new Discount20()); // Assign option
		DecimalFormat df = new DecimalFormat("#.##"); 
		
		double price = 2.52; // Assign test values
		int quantity = 7;
		
		double value = dis.calculate(price, quantity);
		
		assertEquals("14.11", df.format(value), "Value should be 14.11");
	}
	
	@Test
	void totalTest() {
		// 2.52/7/2/14.11
		// 3/2/1/19.51
		DecimalFormat df = new DecimalFormat("#.##");
		Discount dis = new Discount();
		dis.setDiscount(new Discount20());
		
		double price = 2.52;
		int quantity = 7;
		
		double total = dis.calculate(price, quantity);
		
		dis.setDiscount(new Discount10());
		
		price = 3;
		quantity = 2;
		
		total += dis.calculate(price, quantity);
		
		assertEquals("19.51", df.format(total), "Value should be 19.51");
	}
	
	@Test
	void userInputNullTest() {
		
	}
	
	@Test 
	void userInputWrongTypeTest() {
		
	}
	
	
}
