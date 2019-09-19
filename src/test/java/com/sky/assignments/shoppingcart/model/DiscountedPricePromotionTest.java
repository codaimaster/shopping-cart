package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DiscountedPricePromotionTest {

	private DiscountedPricePromotion underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new DiscountedPricePromotion(new ItemCriteria(null, "Stationary"), 20);
	}

	@Test
	public void testChargeItemDiscountDoesNotApplyTo() {
		BigDecimal actualResult = underTest.charge(new Product("AAA Batteries", "Power", new BigDecimal("20.00")), 10);
		assertNull(actualResult);
	}

	@Test
	public void testChargeItemDiscountAppliesTo() {
		BigDecimal actualResult = underTest.charge(new Product("Pen", "Stationary", new BigDecimal("20.00")), 10);
		assertEquals(new BigDecimal("160.00"), actualResult);
	}

	@Test
	public void testEquals() {
		assertTrue(underTest.equals(new DiscountedPricePromotion(new ItemCriteria(null, "Stationary"), 20)));
		assertFalse(underTest.equals("dummy string"));
		assertFalse(underTest.equals(null));
		assertFalse(underTest.equals(new DiscountedPricePromotion(null, 20)));
		assertFalse(underTest.equals(new DiscountedPricePromotion(new ItemCriteria("", "Stationary"), 20)));
		assertFalse(underTest.equals(new DiscountedPricePromotion(new ItemCriteria(null, "Stationaries"), 20)));
		assertFalse(underTest.equals(new DiscountedPricePromotion(new ItemCriteria(null, "Stationary"), 21)));
	}

}
