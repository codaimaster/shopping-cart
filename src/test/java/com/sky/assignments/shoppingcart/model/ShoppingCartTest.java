package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	private ShoppingCart underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new ShoppingCart("Cart Under Test");
	}

	@Test
	public void testAddItem() {
		assertTrue(underTest.isEmpty());
		underTest.addItem(new Product("Pen", "Stationary", new BigDecimal("20.00")), 10);
		assertEquals(1, underTest.getItemList().size());
		assertEquals(new ShoppingListItem(new Product("Pen", "Stationary", new BigDecimal("20.00")), 10),
				underTest.getItemList().get(0));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(underTest.isEmpty());
		underTest.addItem(new Product("Pen", "Stationary", new BigDecimal("20.00")), 10);
		assertFalse(underTest.isEmpty());
	}

	@Test
	public void testEquals() {
		assertTrue(underTest.equals(new ShoppingCart("Cart Under Test")));
		assertFalse(underTest.equals("dummy string"));
		assertFalse(underTest.equals(null));
		assertFalse(underTest.equals(new ShoppingCart("Card Under Test")));
	}

}
