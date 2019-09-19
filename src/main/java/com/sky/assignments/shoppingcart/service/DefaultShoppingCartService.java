package com.sky.assignments.shoppingcart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sky.assignments.shoppingcart.dao.OnlineShopDao;
import com.sky.assignments.shoppingcart.dao.OnlineShopDaoMockImpl;
import com.sky.assignments.shoppingcart.model.CheckoutData;
import com.sky.assignments.shoppingcart.model.Promotion;
import com.sky.assignments.shoppingcart.model.ShoppingCart;
import com.sky.assignments.shoppingcart.model.ShoppingListItem;

public class DefaultShoppingCartService implements ShoppingCartService {

	private OnlineShopDao onlineShopDao = new OnlineShopDaoMockImpl();

	@Override
	public CheckoutData getCheckOutDataFor(String cartId) {
		if (cartId == null)
			throw new IllegalArgumentException("Cart Id argument must not be null");

		ShoppingCart cart = onlineShopDao.getCartById(cartId);
		List<Promotion> promotions = onlineShopDao.getActivePromotions();
		BigDecimal undiscountedTotal = new BigDecimal(0);
		BigDecimal discountedTotal = new BigDecimal(0);
		List<BigDecimal> discountedRowTotals = new ArrayList<BigDecimal>();
		for (ShoppingListItem record : cart.getItemList()) {
			BigDecimal rowTotal = getChargeForItem(record, promotions);
			undiscountedTotal = undiscountedTotal
					.add(record.getItem().getPrice().multiply(new BigDecimal(record.getCount())));
			discountedTotal = discountedTotal.add(rowTotal);
			discountedRowTotals.add(rowTotal);
		}

		return new CheckoutData(cart, discountedRowTotals, undiscountedTotal, discountedTotal);
	}

	private BigDecimal getChargeForItem(ShoppingListItem record, List<Promotion> promotions) {
		for (Promotion promotion : promotions) {
			BigDecimal discountedCharge = promotion.charge(record.getItem(), record.getCount());
			if (discountedCharge != null)
				return discountedCharge;
		}
		return record.getItem().getPrice().multiply(new BigDecimal(record.getCount()));
	}

}
