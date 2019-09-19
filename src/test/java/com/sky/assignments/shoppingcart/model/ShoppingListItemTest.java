package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingListItemTest {

	private ShoppingListItem underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new ShoppingListItem(new Product("Pen", "Stationary", new BigDecimal("2.30")), 10);
	}

	@Test
	public void testConstruction() {
		assertEquals(new Product("Pen", "Stationary", new BigDecimal("2.30")), underTest.getItem());
		assertEquals(10, underTest.getCount());
	}

	@Test
	public void testEquals() {
		assertTrue(
				underTest.equals(new ShoppingListItem(new Product("Pen", "Stationary", new BigDecimal("2.30")), 10)));
		assertFalse(underTest.equals("dummy string"));
		assertFalse(underTest.equals(null));
		assertFalse(underTest.equals(new ShoppingListItem(null, 10)));
		assertFalse(
				underTest.equals(new ShoppingListItem(new Product(null, "Stationary", new BigDecimal("2.30")), 10)));
		assertFalse(underTest.equals(new ShoppingListItem(new Product("Pen", null, new BigDecimal("2.30")), 10)));
		assertFalse(
				underTest.equals(new ShoppingListItem(new Product("Pen", "Stationary", new BigDecimal("2.31")), 10)));
		assertFalse(
				underTest.equals(new ShoppingListItem(new Product("Pen", "Stationary", new BigDecimal("2.30")), 9)));
	}

}
