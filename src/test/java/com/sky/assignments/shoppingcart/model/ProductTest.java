package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product underTest;

	@Before
	public void setUp() {
		underTest = new Product("Pen", "Stationary", new BigDecimal("2.30"));
	}

	@Test
	public void testConstruction() {
		assertEquals("Pen", underTest.getName());
		assertEquals("Stationary", underTest.getType());
		assertEquals(new BigDecimal("2.30"), underTest.getPrice());
	}

	@Test
	public void testEquals() {
		assertTrue(underTest.equals(new Product("Pen", "Stationary", new BigDecimal("2.30"))));
		assertFalse(underTest.equals("dummy string"));
		assertFalse(underTest.equals(null));
		assertFalse(underTest.equals(new Product(null, "Stationary", new BigDecimal("2.30"))));
		assertFalse(underTest.equals(new Product("Pen", null, new BigDecimal("2.30"))));
		assertFalse(underTest.equals(new Product("Pen", "Stationary", null)));
	}

}
