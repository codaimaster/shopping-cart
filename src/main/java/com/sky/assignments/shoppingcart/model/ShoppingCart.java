package com.sky.assignments.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private String cartId;
	private List<ShoppingListItem> itemList = new ArrayList<ShoppingListItem>();

	public ShoppingCart(String cartId) {
		super();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public List<ShoppingListItem> getItemList() {
		return itemList;
	}

	public boolean isEmpty() {
		return itemList.isEmpty();
	}

	public void addItem(Product item, int count) {
		itemList.add(new ShoppingListItem(item, count));
	}

	@Override
	public String toString() {
		if (itemList.isEmpty())
			return "Empty shopping cart";
		StringBuilder builder = new StringBuilder("Shopping Cart - ").append(cartId).append(":\n");
		itemList.forEach(record -> builder.append(record.getItem().getName()).append('\t').append(record.getCount())
				.append('\n'));
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		return true;
	}

}
