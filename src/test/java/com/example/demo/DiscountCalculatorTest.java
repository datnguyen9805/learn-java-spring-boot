package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

	@Test
	public void testNoDiscount() {
		DiscountCalculator discountObj = new DiscountCalculator();
		// <100
		double total = discountObj.calculateDiscount(50);
		assertEquals(0, total);
	}

	@Test
	public void test1NoDiscount() {
		DiscountCalculator discountObj = new DiscountCalculator();
		// 100< x < 500
		double total = discountObj.calculateDiscount(150);
		assertEquals(15, total);
	}
}
