package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemCriteriaTest {

	private ItemCriteria underTest;

	@Before
	public void setUp() {
		underTest = new ItemCriteria("Pen", "Stationary");
	}

	@Test
	public void testConstruction() {
		assertEquals("Pen", underTest.getNameValue());
		assertEquals("Stationary", underTest.getTypeValue());
	}

	@Test
	public void testEquals() {
		assertTrue(underTest.equals(new ItemCriteria("Pen", "Stationary")));
		assertFalse(underTest.equals("dummy string"));
		assertFalse(underTest.equals(null));
		assertFalse(underTest.equals(new ItemCriteria("Pens", "Stationary")));
		assertFalse(underTest.equals(new ItemCriteria("Pen", "Stationaries")));
	}

}
