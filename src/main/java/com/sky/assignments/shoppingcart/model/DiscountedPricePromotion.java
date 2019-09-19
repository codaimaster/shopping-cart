package com.sky.assignments.shoppingcart.model;

import java.math.BigDecimal;

public class DiscountedPricePromotion extends AbstractPromotion {

	private double percent;

	public DiscountedPricePromotion(ItemCriteria criteria, double percent) {
		super(criteria);
		this.percent = percent;
	}

	@Override
	public BigDecimal charge(Product product, int count) {
		if (appliesTo(product))
			return product.getPrice().multiply(new BigDecimal(count)).multiply(new BigDecimal(100 - percent))
					.divide(new BigDecimal(100));
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(percent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscountedPricePromotion other = (DiscountedPricePromotion) obj;
		if (Double.doubleToLongBits(percent) != Double.doubleToLongBits(other.percent))
			return false;
		return true;
	}

}
