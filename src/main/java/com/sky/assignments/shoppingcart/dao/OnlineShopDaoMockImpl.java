package com.sky.assignments.shoppingcart.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.sky.assignments.shoppingcart.model.DiscountedPricePromotion;
import com.sky.assignments.shoppingcart.model.ItemCriteria;
import com.sky.assignments.shoppingcart.model.MForNPromotion;
import com.sky.assignments.shoppingcart.model.Product;
import com.sky.assignments.shoppingcart.model.Promotion;
import com.sky.assignments.shoppingcart.model.ShoppingCart;

public class OnlineShopDaoMockImpl implements OnlineShopDao {

	private final ItemCriteria allAudio = new ItemCriteria(null, "Audio");
	private final DiscountedPricePromotion first = new DiscountedPricePromotion(allAudio, 30.0);
	private final ItemCriteria aaaBatteries = new ItemCriteria("AAA Batteries", null);
	private final Promotion second = new MForNPromotion(aaaBatteries, 3, 2);

	@Override
	public List<Promotion> getActivePromotions() {
		return Arrays.asList(first, second);
	}

	@Override
	public ShoppingCart getCartById(String cartId) {
		if (cartId == "Cart001") {
			ShoppingCart shoppingCart = new ShoppingCart("Cart001");
			shoppingCart.addItem(new Product("Speakers", "Audio", new BigDecimal("85.00")), 1);
			shoppingCart.addItem(new Product("AAA Batteries", "Power", new BigDecimal("0.85")), 5);
			shoppingCart.addItem(new Product("Protein Bars (Box)", "Food", new BigDecimal("25.00")), 2);
			return shoppingCart;
		}
		return null;
	}

}
