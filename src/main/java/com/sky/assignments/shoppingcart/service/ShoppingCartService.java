package com.sky.assignments.shoppingcart.service;

import com.sky.assignments.shoppingcart.model.CheckoutData;

public interface ShoppingCartService {

	CheckoutData getCheckOutDataFor(String cartId);

}
