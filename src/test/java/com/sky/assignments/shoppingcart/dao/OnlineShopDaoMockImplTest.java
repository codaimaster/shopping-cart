package com.sky.assignments.shoppingcart.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sky.assignments.shoppingcart.model.DiscountedPricePromotion;
import com.sky.assignments.shoppingcart.model.ItemCriteria;
import com.sky.assignments.shoppingcart.model.MForNPromotion;
import com.sky.assignments.shoppingcart.model.Product;
import com.sky.assignments.shoppingcart.model.Promotion;
import com.sky.assignments.shoppingcart.model.ShoppingCart;

public class OnlineShopDaoMockImplTest {

	private OnlineShopDaoMockImpl underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new OnlineShopDaoMockImpl();
	}

	@Test
	public void testGetActivePromotions() {
		ItemCriteria allAudio = new ItemCriteria(null, "Audio");
		DiscountedPricePromotion first = new DiscountedPricePromotion(allAudio, 30.0);
		ItemCriteria aaaBatteries = new ItemCriteria("AAA Batteries", null);
		Promotion second = new MForNPromotion(aaaBatteries, 3, 2);
		List<Promotion> mockPromotions = underTest.getActivePromotions();
		assertEquals(Arrays.asList(first, second), mockPromotions);
	}

	@Test
	public void testGetShoppingCartById() {
		ShoppingCart actualCart = underTest.getCartById("Cart001");

		ShoppingCart expectedCart = new ShoppingCart("Cart001");
		expectedCart.addItem(new Product("Speakers", "Audio", new BigDecimal("85.00")), 1);
		expectedCart.addItem(new Product("AAA Batteries", "Power", new BigDecimal("0.85")), 5);
		expectedCart.addItem(new Product("Protein Bars (Box)", "Food", new BigDecimal("25.00")), 2);
		assertEquals(expectedCart, actualCart);
	}

}
