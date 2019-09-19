package com.sky.assignments.shoppingcart.dao;

import java.util.List;

import com.sky.assignments.shoppingcart.model.Promotion;
import com.sky.assignments.shoppingcart.model.ShoppingCart;

public interface OnlineShopDao {

	List<Promotion> getActivePromotions();

	ShoppingCart getCartById(String cartId);

}
