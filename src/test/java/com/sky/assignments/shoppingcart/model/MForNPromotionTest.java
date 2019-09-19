package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MForNPromotionTest {

	private MForNPromotion underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new MForNPromotion(new ItemCriteria(null, "Stationary"), 3, 2);
	}

	@Test
	public void testChargeItemDiscountDoesNotApplyTo() {
		BigDecimal actualResult = underTest.charge(new Product("AAA Batteries", "Power", new BigDecimal("20.00")), 10);
		assertNull(actualResult);
	}

	@Test
	public void testChargeItemDiscountAppliesTo() {
		BigDecimal actualResult = underTest.charge(new Product("Pen", "Stationary", new BigDecimal("20.00")), 10);
		assertEquals(new BigDecimal("140.00"), actualResult);
	}

}
