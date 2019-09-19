package com.sky.assignments.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutData {

	private ShoppingCart cart;
	private List<BigDecimal> discountedRowTotals;
	private BigDecimal undiscountedTotal;
	private BigDecimal discountedTotal;

	public CheckoutData(ShoppingCart cart, List<BigDecimal> discountedRowTotals, BigDecimal undiscountedTotal,
			BigDecimal discountedTotal) {
		super();
		this.cart = cart;
		this.discountedRowTotals = discountedRowTotals;
		this.undiscountedTotal = undiscountedTotal;
		this.discountedTotal = discountedTotal;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public List<BigDecimal> getDiscountedRowTotals() {
		return discountedRowTotals;
	}

	public BigDecimal getUndiscountedTotal() {
		return undiscountedTotal;
	}

	public BigDecimal getDiscountedTotal() {
		return discountedTotal;
	}

	@Override
	public String toString() {
		if (cart.isEmpty())
			return cart.toString();
		StringBuilder builder = new StringBuilder("Shopping Cart - ").append(cart.getCartId()).append(":\n");
		builder.append("----------------------------------------------------------------------\n");
		builder.append(String.format("%-20s%10s%20s%20s", "Item", "Count", "Before Discount", "After Discount") + "\n");
		builder.append(String.format("%-20s%10s%20s%20s", "-------------------", "---------", "---------------",
				"--------------") + "\n");
		int i = 0;
		for (ShoppingListItem record : cart.getItemList()) {
			BigDecimal undiscountedRowTotal = record.getItem().getPrice().multiply(new BigDecimal(record.getCount()));
			BigDecimal discountedRowTotal = discountedRowTotals.get(i++);
			builder.append(String.format("%-20s%10s%20s%20s", record.getItem().getName(), record.getCount(),
					undiscountedRowTotal, discountedRowTotal) + "\n");
		}

		builder.append(
				String.format("%-20s%30s%20s", "-------------------", "---------------", "--------------") + "\n");
		builder.append(String.format("%-20s%30s%20s", "Grand Totals:", undiscountedTotal, discountedTotal));

		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((discountedRowTotals == null) ? 0 : discountedRowTotals.hashCode());
		result = prime * result + ((discountedTotal == null) ? 0 : discountedTotal.hashCode());
		result = prime * result + ((undiscountedTotal == null) ? 0 : undiscountedTotal.hashCode());
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
		CheckoutData other = (CheckoutData) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (discountedRowTotals == null) {
			if (other.discountedRowTotals != null)
				return false;
		} else if (!discountedRowTotals.equals(other.discountedRowTotals))
			return false;
		if (discountedTotal == null) {
			if (other.discountedTotal != null)
				return false;
		} else if (!discountedTotal.equals(other.discountedTotal))
			return false;
		if (undiscountedTotal == null) {
			if (other.undiscountedTotal != null)
				return false;
		} else if (!undiscountedTotal.equals(other.undiscountedTotal))
			return false;
		return true;
	}

}
