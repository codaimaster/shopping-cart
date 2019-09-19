package com.sky.assignments.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sky.assignments.shoppingcart.dao.OnlineShopDaoMockImpl;

public class CheckoutDataTest {

	private OnlineShopDaoMockImpl mockDao = new OnlineShopDaoMockImpl();
	private ShoppingCart mockCart = mockDao.getCartById("Cart001");
	private List<BigDecimal> discountedRowTotals = Arrays.asList(new BigDecimal("59.50"), new BigDecimal("3.40"),
			new BigDecimal("50.00"));
	private CheckoutData checkoutDataUnderTest;

	@Before
	public void setUp() throws Exception {
		checkoutDataUnderTest = new CheckoutData(mockCart, discountedRowTotals, new BigDecimal("139.25"),
				new BigDecimal("112.90"));
	}

	@Test
	public void testConstruction() {
		assertEquals(mockCart, checkoutDataUnderTest.getCart());
		assertEquals(discountedRowTotals, checkoutDataUnderTest.getDiscountedRowTotals());
		assertEquals(new BigDecimal("112.90"), checkoutDataUnderTest.getDiscountedTotal());
		assertEquals(new BigDecimal("139.25"), checkoutDataUnderTest.getUndiscountedTotal());
	}

	@Test
	public void testToString() {
		String expected = "Shopping Cart - Cart001:\n----------------------------------------------------------------------\n";
		expected += String.format("%-20s%10s%20s%20s", "Item", "Count", "Before Discount", "After Discount") + "\n";
		expected += String.format("%-20s%10s%20s%20s", "-------------------", "---------", "---------------",
				"--------------") + "\n";
		expected += String.format("%-20s%10s%20s%20s", "Speakers", 1, "85.00", "59.50") + "\n";
		expected += String.format("%-20s%10s%20s%20s", "AAA Batteries", 5, "4.25", "3.40") + "\n";
		expected += String.format("%-20s%10s%20s%20s", "Protein Bars (Box)", 2, "50.00", "50.00") + "\n";

		expected += String.format("%-20s%30s%20s", "-------------------", "---------------", "--------------") + "\n";
		expected += String.format("%-20s%30s%20s", "Grand Totals:", "139.25", "112.90");
		String actual = checkoutDataUnderTest.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testEquals() {
		assertTrue(checkoutDataUnderTest.equals(
				new CheckoutData(mockCart, discountedRowTotals, new BigDecimal("139.25"), new BigDecimal("112.90"))));
		assertFalse(checkoutDataUnderTest.equals("dummy string"));
		assertFalse(checkoutDataUnderTest.equals(null));
		assertFalse(checkoutDataUnderTest.equals(
				new CheckoutData(null, discountedRowTotals, new BigDecimal("139.25"), new BigDecimal("112.90"))));
		assertFalse(checkoutDataUnderTest
				.equals(new CheckoutData(mockCart, null, new BigDecimal("139.25"), new BigDecimal("112.90"))));
		assertFalse(checkoutDataUnderTest.equals(
				new CheckoutData(mockCart, discountedRowTotals, new BigDecimal("139.24"), new BigDecimal("112.90"))));
		assertFalse(checkoutDataUnderTest.equals(
				new CheckoutData(mockCart, discountedRowTotals, new BigDecimal("139.25"), new BigDecimal("112.91"))));
	}

}
