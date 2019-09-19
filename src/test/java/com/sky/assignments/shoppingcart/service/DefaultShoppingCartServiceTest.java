package com.sky.assignments.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sky.assignments.shoppingcart.dao.OnlineShopDaoMockImpl;
import com.sky.assignments.shoppingcart.model.CheckoutData;
import com.sky.assignments.shoppingcart.model.ShoppingCart;

public class DefaultShoppingCartServiceTest {

	private DefaultShoppingCartService underTest;
	private OnlineShopDaoMockImpl mockDao = new OnlineShopDaoMockImpl();

	@Before
	public void setUp() throws Exception {
		underTest = new DefaultShoppingCartService();
	}

	@Test
	public void testGetCheckOutDataFor() {
		ShoppingCart mockCart = mockDao.getCartById("Cart001");
		List<BigDecimal> discountedRowTotals = Arrays.asList(new BigDecimal("59.50"), new BigDecimal("3.40"),
				new BigDecimal("50.00"));
		CheckoutData expectedCheckoutData = new CheckoutData(mockCart, discountedRowTotals, new BigDecimal("139.25"),
				new BigDecimal("112.90"));
		CheckoutData actualCheckoutData = underTest.getCheckOutDataFor("Cart001");
		assertEquals(expectedCheckoutData, actualCheckoutData);
	}

}
