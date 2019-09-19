package com.sky.assignments.shoppingcart;

import com.sky.assignments.shoppingcart.service.DefaultShoppingCartService;
import com.sky.assignments.shoppingcart.service.ShoppingCartService;

public class OnlineShopDemo {

	public static void main(String[] args) {
		ShoppingCartService shoppingCartService = new DefaultShoppingCartService();
		System.out.println(shoppingCartService.getCheckOutDataFor("Cart001"));
	}
}
